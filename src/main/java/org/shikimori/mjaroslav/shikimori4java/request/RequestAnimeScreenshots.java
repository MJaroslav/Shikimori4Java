package org.shikimori.mjaroslav.shikimori4java.request;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectImage;

public class RequestAnimeScreenshots extends RequestBase<ObjectImage[]> {
	private int id;

	public RequestAnimeScreenshots(int id) {
		super("animes/", ObjectImage[].class);
		this.id = id;
	}

	public RequestAnimeScreenshots(ShikimoriClient client, int id) {
		super(client, "animes/", ObjectImage[].class);
		this.id = id;
	}

	@Override
	public String getMethod() {
		return super.getMethod() + id + "/screenshots";
	}
}
