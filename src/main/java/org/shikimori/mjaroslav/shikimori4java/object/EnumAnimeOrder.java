package org.shikimori.mjaroslav.shikimori4java.object;

public enum EnumAnimeOrder {
	ID("id"), RANKED("ranked"), KIND("kind"), POPULARITY("popularity"), NAME("name"), AIREDON("aired_on"), EPISODES(
			"episodes"), STATUS("status"), RANDOM("random");

	private final String stringValue;

	EnumAnimeOrder(String value) {
		stringValue = value;
	}

	public String getStringValue() {
		return stringValue;
	}

	public static EnumAnimeOrder fromValue(String value) {
		for (EnumAnimeOrder check : values())
			if (check.stringValue.equals(value))
				return check;
		return null;
	}
}
