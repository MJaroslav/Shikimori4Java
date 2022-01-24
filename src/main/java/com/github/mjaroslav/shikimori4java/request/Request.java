package com.github.mjaroslav.shikimori4java.request;

import com.github.kevinsawicki.http.HttpRequest;
import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.Error;
import com.github.mjaroslav.shikimori4java.throwable.ShikimoriException;
import com.github.mjaroslav.shikimori4java.util.APIVersion;
import com.github.mjaroslav.shikimori4java.util.Utils;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    @NotNull
    public T execute() throws ShikimoriException {
        val result = Utils.fromJson(executeJSON(false), getResponseType());
        if (result == null)
            throw new ShikimoriException("API request result is null");
        return result;
    }

    @NotNull
    public HttpRequest buildHttpRequest() {
        return HttpRequest.get(String.format("%s/%s", version.getUrl(), method), true, getParams()).userAgent(app.getAppName())
                .authorization(app.getAuthorization());
    }

    protected String executeJSON(boolean tokenRefreshed) throws ShikimoriException {
        val request = buildHttpRequest();
        val json = request.body();
        app.getLogger().debug(json);
        try {
            val error = Utils.fromJson(json, Error.class);
            if (error == null)
                throw new ShikimoriException("API request result is null");
            if (!error.hasError())
                return json;
            else if (error.isAuthError() && !tokenRefreshed && app.isRefreshOnError()) {
                app.getLogger().warn("Token expired, trying refresh token...");
                app.login();
                return executeJSON(true);
            } else
                throw new ShikimoriException(error);
        } catch (Exception e) {
            return json;
        }
    }
}
