package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.request.RequestAccessToken;

public class ShikimoriApi {
	public static final String urlBase = "https://shikimori.org";

	public static String createToken(String nickname, String password) {
		return new RequestAccessToken(nickname, password).getResponce().token;
	}

	public static ShikimoriClient getClient(String nickname, String token) {
		return new ShikimoriClient().setNickname(nickname).setToken(token);
	}

	public static ShikimoriClient loginClient(String nickname, String password) {
		return new ShikimoriClient(nickname, password);
	}

	private ShikimoriClient client;

	private ApiAnime anime = new ApiAnime(this);

	public ShikimoriApi(ShikimoriClient client) {
		this.client = client;
	}

	public ShikimoriApi() {
	}

	public void setClient(ShikimoriClient client) {
		this.client = client;
	}

	public ShikimoriClient getClient() {
		return client;
	}

	public ApiAnime anime() {
		return anime;
	}
}
