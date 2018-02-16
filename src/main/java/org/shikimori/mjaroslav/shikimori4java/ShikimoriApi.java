package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.api.ApiAnimes;
import org.shikimori.mjaroslav.shikimori4java.api.ApiMangas;
import org.shikimori.mjaroslav.shikimori4java.request.RequestAccessToken;

public class ShikimoriApi {
	public static final String siteUrl = "https://shikimori.org";
	public static final String apiUrl = siteUrl + "/api";
	public static final String userAgent = "Shikimori4Java @ MJaroslav";

	private ShikimoriClient client;

	private ApiAnimes animes = new ApiAnimes(this);
	private ApiMangas mangas = new ApiMangas(this);

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

	public ApiAnimes animes() {
		return animes;
	}

	public ApiMangas mangas() {
		return mangas;
	}

	public static String createToken(String nickname, String password) {
		return new RequestAccessToken(nickname, password).execute().token;
	}

	public static ShikimoriClient getClient(String nickname, String token) {
		return new ShikimoriClient().setNickname(nickname).setToken(token);
	}

	public static ShikimoriClient loginClient(String nickname, String password) {
		return new ShikimoriClient(nickname, password);
	}
}
