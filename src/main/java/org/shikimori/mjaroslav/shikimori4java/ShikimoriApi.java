package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.request.RequestAccessToken;

public class ShikimoriApi {
	public static String createToken(String nickname, String password) {
		return new RequestAccessToken(nickname, password).getResponce().token;
	}
}
