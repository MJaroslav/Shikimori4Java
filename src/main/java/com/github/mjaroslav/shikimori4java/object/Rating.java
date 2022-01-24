package com.github.mjaroslav.shikimori4java.object;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
public enum Rating {
    NONE("none"), G("g"), PG("pg"), PG13("pg_13"), R("r"), R_PLUS("r_plus"), RX("rx"),

    NOT_NONE("!none"), NOT_G("!g"), NOT_PG("!pg"), NOT_PG13("!pg_13"), NOT_R("!r"), NOT_R_PLUS("!r_plus"), NOT_RX("!rx"),

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
    public Rating reverse() {
        return isKnown() ? isExcluded() ? fromValue(value.substring(1)) : fromValue("!" + value) : UNKNOWN;
    }

    @NotNull
    public static Rating fromValue(@Nullable String value) {
        for (val check : values())
            if (check.value.equals(value))
                return check;
        return UNKNOWN;
    }
}
