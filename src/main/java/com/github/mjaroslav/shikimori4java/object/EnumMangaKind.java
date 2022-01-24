package com.github.mjaroslav.shikimori4java.object;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiredArgsConstructor
public enum EnumMangaKind {
    MANGA("manga"), MANHWA("manhwa"), MANHUA("manhua"), NOVEL("novel"), ONESHOT("one_shot"), DOUJIN("doujin"),

    NOT_MANGA("!manga"), NOT_MANHWA("!manhwa"), NOT_MANHUA("!manhua"), NOT_NOVEL("!novel"), NOT_ONESHOT("!one_shot"),
    NOT_DOUJIN("!doujin"),

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
    public EnumMangaKind reverse() {
        return isKnown() ? isExcluded() ? fromValue(value.substring(1)) : fromValue("!" + value) : UNKNOWN;
    }

    @NotNull
    public static EnumMangaKind fromValue(@Nullable String value) {
        for (val check : values())
            if (check.value.equals(value))
                return check;
        return UNKNOWN;
    }
}
