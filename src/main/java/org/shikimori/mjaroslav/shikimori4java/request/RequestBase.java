package org.shikimori.mjaroslav.shikimori4java.request;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriInfo;
import org.shikimori.mjaroslav.shikimori4java.utils.Utils;

import com.github.kevinsawicki.http.HttpRequest;

public abstract class RequestBase<T> {
	protected String method;
	private final Class<T> responceType;
	private ShikimoriApp app;
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

	public T execute() {
		HttpRequest request = null;
		request = HttpRequest.get(getUrl(), true, getParams()).userAgent(getApp().getUserAgent())
				.header("Authorization", getApp().getAuthorization());
		return Utils.fromJson(request.body(charset.name()), getResponceType());
	}

	public String getJSON() {
		HttpRequest request = null;
		request = HttpRequest.get(getUrl(), true, getParams()).userAgent(getApp().getUserAgent())
				.header("Authorization", getApp().getAuthorization());
		return request.body(charset.name());
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
}
