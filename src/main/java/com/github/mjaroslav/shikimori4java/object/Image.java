package com.github.mjaroslav.shikimori4java.object;

import com.github.mjaroslav.shikimori4java.ShikimoriInfo;
import com.github.mjaroslav.shikimori4java.util.Utils;
import lombok.ToString;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@ToString
public class Image {
    public String original;
    public String preview;

    public final Map<String, String> xSizes = new HashMap<>();

    @NotNull
    private String resolve(@NotNull String value) {
        return value.startsWith("/") ? ShikimoriInfo.URL_SHIKIMORI + value : value;
    }

    @NotNull
    public String getOriginalFull() {
        return resolve(original);
    }

    @NotNull
    public String getPreviewFull() {
        return resolve(preview);
    }

    @Nullable
    public String getMaxX() {
        val result = xSizes.keySet().stream().map(k -> Integer.parseInt(k.substring(1))).max(Comparator.naturalOrder());
        return xSizes.get(result.map(integer -> "x" + integer).orElse(null));
    }

    @Nullable
    public String getMinX() {
        val result = xSizes.keySet().stream().map(k -> Integer.parseInt(k.substring(1))).min(Comparator.naturalOrder());
        return xSizes.get(result.map(integer -> "x" + integer).orElse(null));
    }

    @Nullable
    public String getMaxXFull() {
        val result = getMaxX();
        return Utils.stringNotEmpty(result) ? resolve(result) : null;
    }

    @Nullable
    public String getMinXFull() {
        val result = getMinX();
        return Utils.stringNotEmpty(result) ? resolve(result) : null;
    }
}
