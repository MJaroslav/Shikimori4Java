package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;

public class User {
    @SerializedName("id")
    public int id;

    @SerializedName("nickname")
    public String nickname;

    @SerializedName("avatar")
    public String avatar;

    @SerializedName("image")
    public ImageExtended image;

    @SerializedName("last_online_at")
    public String lastOnline;
}
