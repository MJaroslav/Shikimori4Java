package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;

import java.util.List;

public class ObjectMangaFull extends ObjectManga {
    @SerializedName("english")
    public List<String> nameEnglish;
    @SerializedName("japanese")
    public List<String> nameJapanese;
    @SerializedName("synonyms")
    public List<String> synonyms;
    @SerializedName("score")
    public String score;
    @SerializedName("description")
    public String description;
    @SerializedName("description_html")
    public String descriptionHtml;
    @SerializedName("description_source")
    public String descriptionSource;
    @SerializedName("favoured")
    public boolean favoured;
    @SerializedName("anons")
    public boolean anons;
    @SerializedName("ongoing")
    public boolean ongoing;
    @SerializedName("thread_id")
    public int threadId;
    @SerializedName("topic_id")
    public int topicId;
    @SerializedName("myanimelist_id")
    public int myanimelistId;
}
