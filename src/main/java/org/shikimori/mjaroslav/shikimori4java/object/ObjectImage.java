package org.shikimori.mjaroslav.shikimori4java.object;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriApi;

import com.google.gson.annotations.SerializedName;

public class ObjectImage {
	@SerializedName("original")
	public String original;
	@SerializedName("preview")
	public String preview;

	public String getOriginalFull() {
		return ShikimoriApi.siteUrl + original;
	}

	public String getPreviewFull() {
		return ShikimoriApi.siteUrl + preview;
	}
}
