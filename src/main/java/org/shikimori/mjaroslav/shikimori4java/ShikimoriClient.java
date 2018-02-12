package org.shikimori.mjaroslav.shikimori4java;

public class ShikimoriClient {
	private boolean isLogged;
	private String token;

	public ShikimoriClient() {
		isLogged = false;
		token = "";
	}

	public ShikimoriClient(String nickname, String password) {
		token = ShikimoriApi.createToken(nickname, password);
		isLogged = true;
	}

	public ShikimoriClient(String token) {
		this.token = token;
		isLogged = true;
	}

	public String getToken() {
		return token;
	}
	
	public boolean isLogged() {
		return isLogged;
	}
}
