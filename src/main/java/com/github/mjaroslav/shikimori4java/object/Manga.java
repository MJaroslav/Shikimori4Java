package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;
import com.github.mjaroslav.shikimori4java.ShikimoriInfo;
import lombok.ToString;

@ToString
public class Manga {
    public int id;
    public String name;
    @SerializedName("russian")
    public String nameRussian;
    public Image image;
    public String url;

    public String getUrlFull() {
        return ShikimoriInfo.URL_SHIKIMORI + url;
    }

    public String kind;

    public MangaKind getKindEnum() {
        return MangaKind.fromValue(kind);
    }

    public String status;

    public Status getStatusEnum() {
        return Status.fromValue(status);
    }

    public int volumes;
    public int chapters;
    @SerializedName("aired_on")
    public String airedOn;
    @SerializedName("released_on")
    public String releasedOn;
}
