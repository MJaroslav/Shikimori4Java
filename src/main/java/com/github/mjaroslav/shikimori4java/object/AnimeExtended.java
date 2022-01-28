package com.github.mjaroslav.shikimori4java.object;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

import java.util.List;

@ToString(callSuper = true)
public class AnimeExtended extends Anime {
    @SerializedName("english")
    public List<String> nameEnglish;
    @SerializedName("japanese")
    public List<String> nameJapanese;
    public List<String> synonyms;
    public int duration;
    public String score;
    public String description;
    @SerializedName("description_html")
    public String descriptionHtml;
    @SerializedName("description_source")
    public String descriptionSource;
    public boolean favoured;
    public boolean anons;
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
    public List<Image> screenshots;
}
