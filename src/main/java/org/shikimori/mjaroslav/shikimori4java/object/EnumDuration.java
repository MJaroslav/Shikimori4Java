package org.shikimori.mjaroslav.shikimori4java.object;

public enum EnumDuration {
	S("S"), D("D"), F("F"),

	NOTS("!S"), NOTD("!D"), NOTF("!F");

	private final String stringValue;

	EnumDuration(String value) {
		stringValue = value;
	}

	public String getStringValue() {
		return stringValue;
	}

	public static EnumDuration fromValue(String value) {
		for (EnumDuration check : values())
			if (check.stringValue.equals(value))
				return check;
		return null;
	}
}
