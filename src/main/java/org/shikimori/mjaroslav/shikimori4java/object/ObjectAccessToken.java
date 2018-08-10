package org.shikimori.mjaroslav.shikimori4java.object;

import com.google.gson.annotations.SerializedName;

public class ObjectAccessToken {
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

	@SerializedName("error")
	public String error;

	@SerializedName("error_description")
	public String errorDesc;

	@SerializedName("state")
	public String state;

	public boolean isLogged() {
		return (error == null || error.equals("")) && (state == null || !state.equals("unauthorized"));
	}
}
