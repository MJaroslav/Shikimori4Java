package org.shikimori.mjaroslav.shikimori4java.request;

import org.shikimori.mjaroslav.shikimori4java.responce.ResponceAccessToken;

public class RequestAccessToken extends RequestBase<ResponceAccessToken> {
	private String nickname;
	private String password;

	public RequestAccessToken() {
		super("access_token", ResponceAccessToken.class);
	}

	public RequestAccessToken(String nickname, String password) {
		this();
		this.nickname = nickname;
		this.password = password;
	}

	public RequestAccessToken setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	public RequestAccessToken setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public Object[] getParams() {
		return new Object[] { "nickname", nickname, "password", password };
	}
}
