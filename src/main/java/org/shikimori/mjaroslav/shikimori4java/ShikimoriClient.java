package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.utils.Utils;

public class ShikimoriClient {
	private boolean isLogged;
	private String nickname;
	private String token;

	public ShikimoriClient() {
		isLogged = false;
		token = "";
		nickname = "";
	}

	public ShikimoriClient(String nickname, String password) {
		login(nickname, password);
	}

	public ShikimoriClient setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	public ShikimoriClient setToken(String token) {
		this.token = token;
		if (Utils.stringNotEmpty(nickname))
			isLogged = true;
		return this;
	}

	public ShikimoriClient setNewClient(String nickname, String token) {
		setNickname(nickname);
		setToken(token);
		return this;
	}

	public ShikimoriClient login(String nickname, String password) {
		setNickname(nickname);
		setToken(ShikimoriApi.createToken(nickname, password));
		isLogged = true;
		return this;
	}

	public String getNickname() {
		return nickname;
	}

	public String getToken() {
		return token;
	}

	public boolean isLogged() {
		return isLogged;
	}
}
