package org.shikimori.mjaroslav.shikimori4java.object;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriInfo;

import com.google.gson.annotations.SerializedName;

public class ObjectAnime {
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
        return ShikimoriInfo.API + url;
    }

    @SerializedName("kind")
    public String kind;

    public EnumAnimeKind getKindEnum() {
        return EnumAnimeKind.fromValue(kind);
    }

    @SerializedName("status")
    public String status;

    public EnumStatus getStatusEnum() {
        return EnumStatus.fromValue(status);
    }

    @SerializedName("episodes")
    public int episodes;
    @SerializedName("episodes_aired")
    public int episodesAired;
    @SerializedName("aired_on")
    public String airedOn;
    @SerializedName("released_on")
    public String releasedOn;
}
