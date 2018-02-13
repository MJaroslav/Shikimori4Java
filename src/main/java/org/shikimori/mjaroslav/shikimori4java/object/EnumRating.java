package org.shikimori.mjaroslav.shikimori4java.object;

public enum EnumRating {
	NONE("none"), G("g"), PG("pg"), PG13("pg_13"), R("r"), RPLUS("r_plus"), RX("rx"),

	NOTNONE("!none"), NOTG("!g"), NOTPG("!pg"), NOTPG13("!pg_13"), NOTR("!r"), NOTRPLUS("!r_plus"), NOTRX("!rx");

	private final String stringValue;

	EnumRating(String value) {
		stringValue = value;
	}

	public String getStringValue() {
		return stringValue;
	}

	public static EnumRating fromValue(String value) {
		for (EnumRating check : values())
			if (check.stringValue.equals(value))
				return check;
		return null;
	}
}
