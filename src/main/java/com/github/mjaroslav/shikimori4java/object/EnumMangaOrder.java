package com.github.mjaroslav.shikimori4java.object;

public enum EnumMangaOrder {
    ID("id"), RANKED("ranked"), KIND("kind"), POPULARITY("popularity"), NAME("name"), AIREDON("aired_on"),
    VOLUMES("volumes"), CHAPTERS("chapters"), STATUS("status"), RANDOM("random");

    private final String stringValue;

    EnumMangaOrder(String value) {
        stringValue = value;
    }

    public String getStringValue() {
        return stringValue;
    }

    public static EnumMangaOrder fromValue(String value) {
        for (EnumMangaOrder check : values())
            if (check.stringValue.equals(value))
                return check;
        return null;
    }
}
