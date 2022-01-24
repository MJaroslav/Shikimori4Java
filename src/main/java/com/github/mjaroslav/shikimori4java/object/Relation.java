package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;

public class Relation {
    @SerializedName("relation")
    public String relation;
    @SerializedName("relation_russian")
    public String relationRussian;
    @SerializedName("anime")
    public Anime anime;
    @SerializedName("manga")
    public Manga manga;
}
