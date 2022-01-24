package com.github.mjaroslav.shikimori4java.object;

import com.github.mjaroslav.shikimori4java.ShikimoriInfo;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@ToString
public class Image {
    public String original;
    public String preview;

    public final Map<String, String> xSizes = new HashMap<>();

    @NotNull
    public String getOriginalFull() {
        return ShikimoriInfo.URL_SHIKIMORI + original;
    }

    @NotNull
    public String getPreviewFull() {
        return ShikimoriInfo.URL_SHIKIMORI + preview;
    }
}
