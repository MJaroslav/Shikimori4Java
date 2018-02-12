package org.shikimori.mjaroslav.shikimori4java.request;

import java.nio.charset.StandardCharsets;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;

public class RequestBase<T> {
	public static final String urlBase = "https://shikimori.org/api/";
	public static final Gson gson = new Gson();
	private String method;
	private final Class<T> responceType;

	public RequestBase(String method, Class<T> responceType) {
		this.method = method;
		this.responceType = responceType;
	}

	public String getMethod() {
		return method;
	}

	public Object[] getParams() {
		return new Object[0];
	}

	public T getResponce() {
		String body = HttpRequest.get(urlBase + method, true, getParams()).body(StandardCharsets.UTF_8.name());
		return gson.fromJson(body, responceType);
	}

	public Class<T> getResponceType() {
		return responceType;
	}
}
