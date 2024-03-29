package com.github.mjaroslav.shikimori4java.object;

import com.github.mjaroslav.shikimori4java.ShikimoriInfo;
import com.google.gson.annotations.SerializedName;
import lombok.ToString;

@ToString
public class PersonCharacter {
    public int id;
    public String name;
    @SerializedName("russian")
    public String nameRussian;
    public Image image;
    public String url;

    public String getUrlFull() {
        return ShikimoriInfo.URL_SHIKIMORI + url;
    }
}
