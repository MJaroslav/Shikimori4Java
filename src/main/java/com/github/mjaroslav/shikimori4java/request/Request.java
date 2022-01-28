package com.github.mjaroslav.shikimori4java.request;

import com.github.kevinsawicki.http.HttpRequest;
import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.logger.LogManager;
import com.github.mjaroslav.shikimori4java.object.Error;
import com.github.mjaroslav.shikimori4java.throwable.login.LoginErrorException;
import com.github.mjaroslav.shikimori4java.throwable.runtime.AuthRequiredException;
import com.github.mjaroslav.shikimori4java.throwable.runtime.RequestErrorException;
import com.github.mjaroslav.shikimori4java.throwable.runtime.TokenExpiredException;
import com.github.mjaroslav.shikimori4java.util.APIVersion;
import com.github.mjaroslav.shikimori4java.util.Utils;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Getter
@ToString
public class Request<T> {
    @NotNull
    protected final ShikimoriApp app;
    @NotNull
    protected final String method;
    @NotNull
    protected final Class<T> responseType;
    @NotNull
    protected final APIVersion version;
    @NotNull
    protected final Map<String, Object> params = new HashMap<>();
    protected final boolean authRequired;

    public Object setParam(@NotNull String name, @Nullable Object value) {
        if (value == null)
            params.remove(name);
        else
            params.put(name, value);
        return value;
    }

    @Nullable
    public Object getParam(@NotNull String name) {
        return params.getOrDefault(name, null);
    }

    @NotNull
    public Object getParam(@NotNull String name, @NotNull Object defaultValue) {
        var result = getParam(name);
        if (result == null)
            result = setParam(name, defaultValue);
        return result;
    }

    @NotNull
    public URL getUrl() {
        return buildHttpRequest().url();
    }

    @NotNull
    public Object[] getParams() {
        val result = new ArrayList<>();
        params.forEach((k, v) -> {
            result.add(k);
            result.add(v);
        });
        return result.toArray(new Object[0]);
    }

    @UnknownNullability
    public T execute() {
        if (app.isLogged())
            if (isAuthRequired() && app.isPublicApiOnly())
                throw new AuthRequiredException("This not public API request");
            else
                return Utils.fromJson(executeJSON(false), getResponseType());
        else throw new RequestErrorException("Application is not logged");
    }

    @NotNull
    public HttpRequest buildHttpRequest() {
        var result = HttpRequest.get(String.format("%s/%s", version.getUrl(), method), true, getParams()).userAgent(app.getAppName());
        return app.isPublicApiOnly() ? result : result.authorization(app.getAuthorization());
    }

    protected String executeJSON(boolean tokenRefreshed) {
        val request = buildHttpRequest();
        LogManager.getLogger().debug(String.valueOf(request.url()));
        val code = request.code();
        val json = request.body();
        LogManager.getLogger().debug("Code: " + code, ", body: " + json);
        if (code == 429) {
            LogManager.getLogger().warn("So many requests! Calming down...");
            try {
                Thread.sleep(1000);
                return executeJSON(tokenRefreshed);
            } catch (InterruptedException e) {
                throw new TokenExpiredException(e);
            }
        }
        if (code == 401) {
            try {
                if (!tokenRefreshed && app.isRefreshOnError() && !app.isPublicApiOnly()) {
                    LogManager.getLogger().warn("Token expired, trying refresh token...");
                    app.refreshToken(true);
                    return executeJSON(true);
                }
            } catch (LoginErrorException e) {
                throw new TokenExpiredException(e);
            }
        }

        LogManager.getLogger().debug(json);
        try {
            val error = Utils.fromJson(json, Error.class);
            if (error == null)
                return json;
            if (!error.hasError())
                return json;
            throw new RequestErrorException(error);
        } catch (Exception e) {
            throw new RequestErrorException(e);
        }
    }
}
