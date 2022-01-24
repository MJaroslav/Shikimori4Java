package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;

public class ObjectRelation {
    @SerializedName("relation")
    public String relation;
    @SerializedName("relation_russian")
    public String relationRussian;
    @SerializedName("anime")
    public ObjectAnime anime;
    @SerializedName("manga")
    public ObjectManga manga;
}
