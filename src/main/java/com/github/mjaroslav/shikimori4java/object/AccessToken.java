package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;
import lombok.ToString;

@ToString(callSuper = true)
public class AccessToken extends Error {
    @SerializedName("access_token")
    public String accessToken;

    @SerializedName("token_type")
    public String tokenType;

    @SerializedName("refresh_token")
    public String refreshToken;

    @SerializedName("expires_in")
    public long expiresIn;

    @SerializedName("created_at")
    public long createdAt;

    public boolean isRefreshRequired() {
        return (createdAt * expiresIn) * 1000 < System.currentTimeMillis();
    }
}
