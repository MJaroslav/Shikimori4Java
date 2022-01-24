package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.Nullable;
import blue.endless.jankson.annotation.SerializedName;
import com.github.mjaroslav.shikimori4java.util.Utils;

public class ImageExtended extends Image {
    @SerializedName("x160")
    public String x160;
    @SerializedName("x148")
    public String x148;
    @SerializedName("x96")
    public String x96;
    @SerializedName("x80")
    public String x80;
    @SerializedName("x64")
    public String x64;
    @SerializedName("x48")
    public String x48;
    @SerializedName("x32")
    public String x32;
    @SerializedName("x16")
    public String x16;

    @Nullable
    public String getMin() {
        if (!Utils.stringNotEmpty(x16))
            return x16;
        else if (!Utils.stringNotEmpty(x32))
            return x32;
        else if (!Utils.stringNotEmpty(x48))
            return x48;
        else if (!Utils.stringNotEmpty(x64))
            return x64;
        else if (!Utils.stringNotEmpty(x80))
            return x80;
        else if (!Utils.stringNotEmpty(x96))
            return x96;
        else if (!Utils.stringNotEmpty(x148))
            return x148;
        else if (!Utils.stringNotEmpty(x160))
            return x160;
        else
            return null;
    }

    @Nullable
    public String getMax() {
        if (!Utils.stringNotEmpty(x160))
            return x160;
        else if (!Utils.stringNotEmpty(x148))
            return x148;
        else if (!Utils.stringNotEmpty(x96))
            return x96;
        else if (!Utils.stringNotEmpty(x80))
            return x80;
        else if (!Utils.stringNotEmpty(x64))
            return x64;
        else if (!Utils.stringNotEmpty(x48))
            return x48;
        else if (!Utils.stringNotEmpty(x32))
            return x32;
        if (!Utils.stringNotEmpty(x16))
            return x16;
        else
            return null;
    }
}
