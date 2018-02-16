package org.shikimori.mjaroslav.shikimori4java.object;

public enum EnumMangaKind {
	MANGA("manga"), MANHWA("manhwa"), MANHUA("manhua"), NOVEL("novel"), ONESHOT("one_shot"), DOUJIN("doujin"),

	NOTMANGA("!manga"), NOTMANHWA("!manhwa"), NOTMANHUA("!manhua"), NOTNOVEL("!novel"), NOTONESHOT(
			"!one_shot"), NOTDOUJIN("!doujin");

	private final String stringValue;

	EnumMangaKind(String value) {
		stringValue = value;
	}

	public String getStringValue() {
		return stringValue;
	}

	public static EnumMangaKind fromValue(String value) {
		for (EnumMangaKind check : values())
			if (check.stringValue.equals(value))
				return check;
		return null;
	}
}
