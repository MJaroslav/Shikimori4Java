package org.shikimori.mjaroslav.shikimori4java.object;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriInfo;
import org.shikimori.mjaroslav.shikimori4java.utils.Utils;

import com.google.gson.annotations.SerializedName;

public class ObjectImageFull extends ObjectImage {
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

    public String getX160Full() {
        return ShikimoriInfo.API + x160;
    }

    public String getX148Full() {
        return ShikimoriInfo.API + x148;
    }

    public String getX96Full() {
        return ShikimoriInfo.API + x96;
    }

    public String getX80Full() {
        return ShikimoriInfo.API + x80;
    }

    public String getX64Full() {
        return ShikimoriInfo.API + x64;
    }

    public String getX48Full() {
        return ShikimoriInfo.API + x48;
    }

    public String getX32Full() {
        return ShikimoriInfo.API + x32;
    }

    public String getX16Full() {
        return ShikimoriInfo.API + x16;
    }

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
            return "";
    }

    public String getMinFull() {
        return ShikimoriInfo.API + getMin();
    }

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
            return "";
    }

    public String getMaxFull() {
        return ShikimoriInfo.API + getMax();
    }
}
