package org.shikimori.mjaroslav.shikimori4java.request;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApi;
import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.utils.Utils;

import com.github.kevinsawicki.http.HttpRequest;

public class RequestBase<T> {
	protected String method;
	private final Class<T> responceType;
	private ShikimoriClient client;
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

	public RequestBase(ShikimoriClient client, String method, Class<T> responceType) {
		this.client = client;
		this.method = method;
		this.responceType = responceType;
	}

	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return ShikimoriApi.apiUrl + "/" + getMethod();
	}

	public void setClient(ShikimoriClient client) {
		this.client = client;
	}

	public ShikimoriClient getClient() {
		return client;
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
		if (Utils.clientExist(getClient()))
			request = HttpRequest.get(getUrl(), true, getParams()).userAgent(getClient().getUserAgent())
					.header("Authorization", getClient().getAuthorization());
		return Utils.fromJson(request.body(charset.name()), getResponceType());
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
