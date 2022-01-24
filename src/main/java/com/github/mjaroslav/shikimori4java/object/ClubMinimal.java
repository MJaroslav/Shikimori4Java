package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;

// TODO
public class ClubMinimal {
    public int id;
    public String name;
    public Image logo;
    @SerializedName("is_censored")
    public boolean isCensored;
    @SerializedName("join_policy")
    public String joinPolicy;
    @SerializedName("comment_policy")
    public String commentPolicy;
}
