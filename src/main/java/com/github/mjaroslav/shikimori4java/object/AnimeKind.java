package com.github.mjaroslav.shikimori4java.object;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
@ToString
public enum AnimeKind {
    TV("tv"), MOVIE("movie"), OVA("ova"), ONA("ona"), SPECIAL("special"), MUSIC("music"), TV13("tv_13"), TV24("tv_24"),
    TV48("tv_48"),

    NOT_TV("!tv"), NOT_MOVIE("!movie"), NOT_OVA("!ova"), NOT_ONA("!ona"), NOT_SPECIAL("!special"), NOT_MUSIC("!music"),
    NOT_TV13("!tv_13"), NOT_TV24("!tv_24"), NOT_TV48("!tv_48"),

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
    public AnimeKind reverse() {
        return isKnown() ? isExcluded() ? fromValue(value.substring(1)) : fromValue("!" + value) : UNKNOWN;
    }

    @NotNull
    public static AnimeKind fromValue(@Nullable String value) {
        for (val check : values())
            if (check.value.equals(value))
                return check;
        return UNKNOWN;
    }
}
