package com.github.mjaroslav.shikimori4java.object;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
public enum AnimeOrder {
    ID("id"), RANKED("ranked"), KIND("kind"), POPULARITY("popularity"), NAME("name"), AIRED_ON("aired_on"),
    EPISODES("episodes"), STATUS("status"), RANDOM("random"), UNKNOWN("unknown");

    @Getter
    @NotNull
    private final String value;

    public boolean isKnown() {
        return this != UNKNOWN;
    }

    @NotNull
    public static AnimeOrder fromValue(@Nullable String value) {
        for (val check : values())
            if (check.value.equals(value))
                return check;
        return UNKNOWN;
    }
}
