package org.shikimori.mjaroslav.shikimori4java.responce;

import com.google.gson.annotations.SerializedName;

public class ResponceAccessToken extends ResponceBase {
	@SerializedName("api_access_token")
	public String token;
}
