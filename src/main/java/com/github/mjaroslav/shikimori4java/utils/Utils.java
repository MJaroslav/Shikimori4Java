package com.github.mjaroslav.shikimori4java.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {
    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static boolean stringNotEmpty(String str) {
        return str != null && str.length() > 0 && !str.equals("null");
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
