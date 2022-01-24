package com.github.mjaroslav.shikimori4java.object;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
public enum Status {
    ANONS("anons"), ONGOING("ongoing"), RELEASED("released"),

    NOT_ANONS("!anons"), NOT_ONGOING("!ongoing"), NOT_RELEASED("!released"),

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
    public Status reverse() {
        return isKnown() ? isExcluded() ? fromValue(value.substring(1)) : fromValue("!" + value) : UNKNOWN;
    }

    @NotNull
    public static Status fromValue(@Nullable String value) {
        for (val check : values())
            if (check.value.equals(value))
                return check;
        return UNKNOWN;
    }
}
