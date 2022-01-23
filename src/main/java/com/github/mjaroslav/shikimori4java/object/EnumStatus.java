package com.github.mjaroslav.shikimori4java.object;

public enum EnumStatus {
    ANONS("anons"), ONGOING("ongoing"), RELEASED("released"),

    NOTANONS("!anons"), NOTONGOING("!ongoing"), NOTRELEASED("!released");

    private final String stringValue;

    EnumStatus(String value) {
        stringValue = value;
    }

    public String getStringValue() {
        return stringValue;
    }

    public static EnumStatus fromValue(String value) {
        for (EnumStatus check : values())
            if (check.stringValue.equals(value))
                return check;
        return null;
    }
}
