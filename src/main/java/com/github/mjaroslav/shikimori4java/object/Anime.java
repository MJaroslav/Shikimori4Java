package com.github.mjaroslav.shikimori4java.object;

import com.github.mjaroslav.shikimori4java.ShikimoriInfo;
import com.google.gson.annotations.SerializedName;
import lombok.ToString;

@ToString
public class Anime {
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

    public AnimeKind getKindEnum() {
        return AnimeKind.fromValue(kind);
    }

    public String status;

    public Status getStatusEnum() {
        return Status.fromValue(status);
    }

    public int episodes;
    @SerializedName("episodes_aired")
    public int episodesAired;
    @SerializedName("aired_on")
    public String airedOn;
    @SerializedName("released_on")
    public String releasedOn;
}
