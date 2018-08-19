package org.shikimori.mjaroslav.shikimori4java.object;

import com.google.gson.annotations.SerializedName;

public class ObjectUser {
    @SerializedName("id")
    public int id;

    @SerializedName("nickname")
    public String nickname;

    @SerializedName("avatar")
    public String avatar;

    @SerializedName("image")
    public ObjectImageFull image;

    @SerializedName("last_online_at")
    public String lastOnline;
}
