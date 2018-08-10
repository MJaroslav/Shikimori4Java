package org.shikimori.mjaroslav.shikimori4java.utils;

import com.google.gson.Gson;

public class Utils {
	public static final Gson gson = new Gson();

	public static boolean stringNotEmpty(String str) {
		return str != null && str.length() > 0 && !str.equals("null");
	}

	public static <T> T fromJson(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}
}
