package org.shikimori.mjaroslav.shikimori4java.request;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriInfo;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectError;
import org.shikimori.mjaroslav.shikimori4java.utils.ShikimoriException;
import org.shikimori.mjaroslav.shikimori4java.utils.Utils;

import com.github.kevinsawicki.http.HttpRequest;

public abstract class RequestBase<T> {
    protected String method;
    private final Class<T> responceType;
    private ShikimoriApp app;
    private boolean needToken = true;
    private boolean refreshToken = true;
    protected Map<String, Object> params = new HashMap<String, Object>();
    private Charset charset = StandardCharsets.UTF_8;

    public Object setParam(String name, Object value) {
        params.put(name, value);
        return value;
    }

    public Object getParam(String name) {
        return params.containsKey(name) ? params.get(name) : null;
    }

    public Object getParam(String name, Object defaultValue) {
        Object result = getParam(name);
        if (result == null)
            result = setParam(name, defaultValue);
        return result;
    }

    public RequestBase(String method, Class<T> responceType) {
        this.method = method;
        this.responceType = responceType;
    }

    public RequestBase(ShikimoriApp app, String method, Class<T> responceType) {
        this.app = app;
        this.method = method;
        this.responceType = responceType;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return ShikimoriInfo.API + "/" + getMethod();
    }

    public ShikimoriApp getApp() {
        return app;
    }

    public Object[] getParams() {
        ArrayList<Object> result = new ArrayList<Object>();
        for (Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() != null
                    || (entry.getValue() instanceof String && Utils.stringNotEmpty((String) entry.getValue()))) {
                result.add(entry.getKey());
                result.add(entry.getValue());
            }
        }
        return result.toArray(new Object[0]);
    }

    public T execute() throws ShikimoriException {
        return Utils.fromJson(executeJSON(), getResponceType());
    }

    public String executeJSON() throws ShikimoriException {
        HttpRequest request = HttpRequest.get(getUrl(), true, getParams()).userAgent(getApp().getUserAgent())
                .header("Authorization", getApp().getAuthorization());
        if (isNeedToken())
            request.header("Authorization", getApp().getAuthorization());
        String json = request.body(charset.name());
        getApp().getAppLogger().debug(json);
        try {
            ObjectError error = Utils.fromJson(json, ObjectError.class);
            if (!error.hasError())
                return json;
            else if (!error.isNotAuthError() && canRefreshToken() && app.canRefreshTokenOnRequestError()) {
                app.getAppLogger().warn("Error on request execution, trying token update...");
                canRefreshToken(false);
                app.refreshToken();
                return executeJSON();
            } else
                throw new ShikimoriException(error);
        } catch (Exception e) {
            return json;
        }
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public Charset getCharset() {
        return charset;
    }

    public Class<T> getResponceType() {
        return responceType;
    }

    public boolean isNeedToken() {
        return needToken;
    }

    public void setNeedToken(boolean needToken) {
        this.needToken = needToken;
    }

    public boolean canRefreshToken() {
        return refreshToken;
    }

    public void canRefreshToken(boolean can) {
        this.refreshToken = can;
    }
}
