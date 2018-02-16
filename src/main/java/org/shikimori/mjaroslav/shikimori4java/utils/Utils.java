package org.shikimori.mjaroslav.shikimori4java.utils;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriApi;
import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;

import com.google.gson.Gson;

public class Utils {
	public static final Gson gson = new Gson();

	public static boolean stringNotEmpty(String str) {
		return str != null && str.length() > 0;
	}

	public static boolean clientExist(ShikimoriClient client) {
		return client != null && client.isLogged();
	}

	public static boolean apiHasClient(ShikimoriApi api) {
		return clientExist(api.getClient());
	}

	public static <T> T fromJson(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}
}
