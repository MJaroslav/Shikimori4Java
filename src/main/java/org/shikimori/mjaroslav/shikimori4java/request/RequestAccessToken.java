package org.shikimori.mjaroslav.shikimori4java.request;

import org.shikimori.mjaroslav.shikimori4java.responce.ResponceAccessToken;

public class RequestAccessToken extends RequestBase<ResponceAccessToken> {
	public RequestAccessToken() {
		super("access_token", ResponceAccessToken.class);
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

	public String getNickname() {
		return (String) getParam("nickname");
	}

	public String getPassword() {
		return (String) getParam("password");
	}
}
