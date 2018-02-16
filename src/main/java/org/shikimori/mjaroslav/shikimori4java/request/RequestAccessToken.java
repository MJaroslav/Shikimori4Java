package org.shikimori.mjaroslav.shikimori4java.request;

import org.shikimori.mjaroslav.shikimori4java.object.ObjectAccessToken;

public class RequestAccessToken extends RequestBase<ObjectAccessToken> {
	public RequestAccessToken() {
		super("access_token", ObjectAccessToken.class);
	}

	public RequestAccessToken(String nickname, String password) {
		this();
		setParam("nickname", nickname);
		setParam("password", password);
	}

	public RequestAccessToken setNickname(String nickname) {
		setParam("nickname", nickname);
		return this;
	}

	public RequestAccessToken setPassword(String password) {
		setParam("password", password);
		return this;
	}
}
