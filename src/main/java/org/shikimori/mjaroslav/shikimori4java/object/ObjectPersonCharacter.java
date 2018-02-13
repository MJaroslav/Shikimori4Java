package org.shikimori.mjaroslav.shikimori4java.object;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriApi;

import com.google.gson.annotations.SerializedName;

public class ObjectPersonCharacter {
	@SerializedName("id")
	public int id;
	@SerializedName("name")
	public String name;
	@SerializedName("russian")
	public String nameRussian;
	@SerializedName("image")
	public ObjectImageFull image;
	@SerializedName("url")
	public String url;

	public String getUrlFull() {
		return ShikimoriApi.urlBase + url;
	}
}
