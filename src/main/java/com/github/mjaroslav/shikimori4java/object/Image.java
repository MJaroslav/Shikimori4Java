package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;
import com.github.mjaroslav.shikimori4java.ShikimoriInfo;

public class Image {
    @SerializedName("original")
    public String original;
    @SerializedName("preview")
    public String preview;

    public String getOriginalFull() {
        return ShikimoriInfo.URL_SHIKIMORI + original;
    }

    public String getPreviewFull() {
        return ShikimoriInfo.URL_SHIKIMORI + preview;
    }
}
