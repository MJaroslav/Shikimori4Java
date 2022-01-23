package com.github.mjaroslav.shikimori4java.object;

import com.github.mjaroslav.shikimori4java.core.ShikimoriInfo;

import com.google.gson.annotations.SerializedName;

public class ObjectManga {
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("russian")
    public String nameRussian;
    @SerializedName("image")
    public ObjectImageFull image;
    @SerializedName("url")
    public String url;

    public String getUrlFull() {
        return ShikimoriInfo.SHIKIMORI + url;
    }

    @SerializedName("kind")
    public String kind;

    public EnumMangaKind getKindEnum() {
        return EnumMangaKind.fromValue(kind);
    }

    @SerializedName("status")
    public String status;

    public EnumStatus getStatusEnum() {
        return EnumStatus.fromValue(status);
    }

    @SerializedName("volumes")
    public int volumes;
    @SerializedName("chapters")
    public int chapters;
    @SerializedName("aired_on")
    public String airedOn;
    @SerializedName("released_on")
    public String releasedOn;
}
