package org.shikimori.mjaroslav.shikimori4java.object;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriApi;

import com.google.gson.annotations.SerializedName;

public class ObjectImage {
	@SerializedName("original")
	public String original;
	@SerializedName("preview")
	public String preview;
	@SerializedName("x96")
	public String x96;
	@SerializedName("x48")
	public String x48;

	public String getOriginalFull() {
		return ShikimoriApi.urlBase + original;
	}

	public String getPreviewFull() {
		return ShikimoriApi.urlBase + preview;
	}

	public String getX48Full() {
		return ShikimoriApi.urlBase + x48;
	}

	public String getX96Full() {
		return ShikimoriApi.urlBase + x96;
	}
}
