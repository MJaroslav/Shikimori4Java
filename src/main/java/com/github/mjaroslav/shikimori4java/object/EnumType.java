package com.github.mjaroslav.shikimori4java.object;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
public enum EnumType {
    PLANNED("planned"), WATCHING("watching"), REWATCHING("rewatching"), COMPLETED("completed"), ON_HOLD("on_hold"),
    DROPPED("dropped"),

    NOT_PLANNED("!planned"), NOT_WATCHING("!watching"), NOT_REWATCHING("!rewatching"), NOT_COMPLETED("!completed"),
    NOT_ON_HOLD("!on_hold"), NOT_DROPPED("!dropped"),

    UNKNOWN("unknown");

    @Getter
    @NotNull
    private final String value;

    public boolean isExcluded() {
        return value.startsWith("!");
    }

    public boolean isKnown() {
        return this != UNKNOWN;
    }

    @NotNull
    public EnumType reverse() {
        return isKnown() ? isExcluded() ? fromValue(value.substring(1)) : fromValue("!" + value) : UNKNOWN;
    }

    @NotNull
    public static EnumType fromValue(@Nullable String value) {
        for (EnumType check : values())
            if (check.value.equals(value))
                return check;
        return UNKNOWN;
    }
}
