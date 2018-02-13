package org.shikimori.mjaroslav.shikimori4java.request;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.utils.Utils;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;

public class RequestBase<T> {
	public static final String urlBase = "https://shikimori.org/api/";
	public static final Gson gson = new Gson();
	private String method;
	private final Class<T> responceType;
	private ShikimoriClient client;
	protected Map<String, Object> params = new HashMap<String, Object>();

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

	public T getResponce() {
		String agent = "Shikimori4Java @ MJaroslav";
		HttpRequest request = HttpRequest.get(urlBase + method, true, getParams()).userAgent(agent);
		if (client != null && client.isLogged())
			request = request.header("X-User-Nickname", getClient().getNickname()).header("X-User-Api-Access-Token",
					getClient().getToken());
		return gson.fromJson(request.body(StandardCharsets.UTF_8.name()), responceType);
	}

	public Class<T> getResponceType() {
		return responceType;
	}
}
