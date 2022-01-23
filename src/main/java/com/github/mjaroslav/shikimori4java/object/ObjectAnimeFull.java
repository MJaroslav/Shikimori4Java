package com.github.mjaroslav.shikimori4java.object;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ObjectAnimeFull extends ObjectAnime {
    @SerializedName("english")
    public List<String> nameEnglish;
    @SerializedName("japanese")
    public List<String> nameJapanese;
    @SerializedName("synonyms")
    public List<String> synonyms;
    @SerializedName("duration")
    public int duration;
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
    @SerializedName("updated_at")
    public String updatedAt;
    @SerializedName("next_episode_at")
    public String nextEpisodeAt;
    @SerializedName("screenshots")
    public List<ObjectImage> screenshots;
}
