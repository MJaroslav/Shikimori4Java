package org.shikimori.mjaroslav.shikimori4java.object;

import com.google.gson.annotations.SerializedName;

public class ObjectAccessToken extends ObjectError {
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
}
