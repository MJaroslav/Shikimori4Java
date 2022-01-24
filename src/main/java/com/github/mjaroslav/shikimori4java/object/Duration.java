package com.github.mjaroslav.shikimori4java.object;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
public enum Duration {
    S("S"), D("D"), F("F"),

    NOT_S("!S"), NOT_D("!D"), NOT_F("!F"),

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
    public Duration reverse() {
        return isKnown() ? isExcluded() ? fromValue(value.substring(1)) : fromValue("!" + value) : UNKNOWN;
    }

    @NotNull
    public static Duration fromValue(@Nullable String value) {
        for (val check : values())
            if (check.value.equals(value))
                return check;
        return UNKNOWN;
    }
}
