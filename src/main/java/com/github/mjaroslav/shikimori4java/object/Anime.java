package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;
import com.github.mjaroslav.shikimori4java.ShikimoriInfo;

public class Anime {
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

    @SerializedName("kind")
    public String kind;

    public AnimeKind getKindEnum() {
        return AnimeKind.fromValue(kind);
    }

    @SerializedName("status")
    public String status;

    public Status getStatusEnum() {
        return Status.fromValue(status);
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
