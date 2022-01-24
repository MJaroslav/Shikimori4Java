package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;
import com.github.mjaroslav.shikimori4java.ShikimoriInfo;

public class PersonCharacter {
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("russian")
    public String nameRussian;
    @SerializedName("image")
    public ImageExtended image;
    @SerializedName("url")
    public String url;

    public String getUrlFull() {
        return ShikimoriInfo.URL_SHIKIMORI + url;
    }
}
