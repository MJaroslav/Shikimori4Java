package org.shikimori.mjaroslav.shikimori4java.object;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriApi;

import com.google.gson.annotations.SerializedName;

public class ObjectImageFull extends ObjectImage {
	@SerializedName("x96")
	public String x96;
	@SerializedName("x48")
	public String x48;

	public String getX48Full() {
		return ShikimoriApi.siteUrl + x48;
	}

	public String getX96Full() {
		return ShikimoriApi.siteUrl + x96;
	}
}
