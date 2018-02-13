package org.shikimori.mjaroslav.shikimori4java.responce;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriApi;
import org.shikimori.mjaroslav.shikimori4java.object.EnumAnimeKind;
import org.shikimori.mjaroslav.shikimori4java.object.EnumStatus;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectImage;

import com.google.gson.annotations.SerializedName;

public class ResponceAnime {
	@SerializedName("id")
	public int id;
	@SerializedName("name")
	public String name;
	@SerializedName("russian")
	public String russianName;
	@SerializedName("image")
	public ObjectImage image;
	@SerializedName("url")
	public String url;

	public String getUrlFull() {
		return ShikimoriApi.urlBase + url;
	}

	@SerializedName("kind")
	public String kind;

	public EnumAnimeKind getKindEnum() {
		return EnumAnimeKind.fromValue(kind);
	}

	@SerializedName("status")
	public String status;

	public EnumStatus getStatusEnum() {
		return EnumStatus.fromValue(status);
	}

	@SerializedName("episodes")
	public int episodes;
	@SerializedName("episodes_aired")
	public int episodesAired;
	@SerializedName("aired_on")
	public String airedOn;
	@SerializedName("released_on")
	public String releasedOn;
}
