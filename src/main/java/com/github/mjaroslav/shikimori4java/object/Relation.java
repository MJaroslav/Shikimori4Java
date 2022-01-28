package com.github.mjaroslav.shikimori4java.object;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

@ToString
public class Relation {
    public String relation;
    @SerializedName("relation_russian")
    public String relationRussian;
    public Anime anime;
    public Manga manga;
}
