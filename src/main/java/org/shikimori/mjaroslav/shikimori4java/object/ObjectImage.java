package org.shikimori.mjaroslav.shikimori4java.object;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriInfo;

import com.google.gson.annotations.SerializedName;

public class ObjectImage {
    @SerializedName("original")
    public String original;
    @SerializedName("preview")
    public String preview;

    public String getOriginalFull() {
        return ShikimoriInfo.SHIKIMORI + original;
    }

    public String getPreviewFull() {
        return ShikimoriInfo.SHIKIMORI + preview;
    }
}
