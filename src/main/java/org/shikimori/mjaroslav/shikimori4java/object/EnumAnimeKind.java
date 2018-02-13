package org.shikimori.mjaroslav.shikimori4java.object;

public enum EnumAnimeKind {
	TV("tv"), MOVIE("movie"), OVA("ova"), ONA("ona"), SPECIAL("special"), MUSIC("music"), TV13("tv_13"), TV24(
			"tv_24"), TV48("tv_48"),

	NOTTV("!tv"), NOTMOVIE("!movie"), NOTOVA("!ova"), NOTONA("!ona"), NOTSPECIAL("!special"), NOTMUSIC(
			"!music"), NOTTV13("!tv_13"), NOTTV24("!tv_24"), NOTTV48("!tv_48");

	private final String stringValue;

	EnumAnimeKind(String value) {
		stringValue = value;
	}

	public String getStringValue() {
		return stringValue;
	}

	public static EnumAnimeKind fromValue(String value) {
		for (EnumAnimeKind check : values())
			if (check.stringValue.equals(value))
				return check;
		return null;
	}
}
