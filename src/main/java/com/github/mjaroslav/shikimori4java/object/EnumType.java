package com.github.mjaroslav.shikimori4java.object;

public enum EnumType {
    PLANNED("planned"), WATCHING("watching"), REWATCHING("rewatching"), COMPLETED("completed"), ONHOLD("on_hold"),
    DROPPED("dropped"),

    NOTPLANNED("!planned"), NOTWATCHING("!watching"), NOTREWATCHING("!rewatching"), NOTCOMPLETED("!completed"),
    NOTONHOLD("!on_hold"), NOTDROPPED("!dropped");

    private final String stringValue;

    EnumType(String value) {
        stringValue = value;
    }

    public String getStringValue() {
        return stringValue;
    }

    public static EnumType fromValue(String value) {
        for (EnumType check : values())
            if (check.stringValue.equals(value))
                return check;
        return null;
    }
}
