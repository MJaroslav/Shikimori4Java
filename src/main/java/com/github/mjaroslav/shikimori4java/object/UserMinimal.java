package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;
import lombok.ToString;

@ToString
public class UserMinimal {
    public int id;
    public String nickname;
    public String avatar;
    public Image image;
    @SerializedName("last_online_at")
    public String lastOnline;
}
