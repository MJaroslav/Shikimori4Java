package org.shikimori.mjaroslav.shikimori4java.request;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectAnime;

public class RequestAnimesSimilar extends RequestBase<ObjectAnime[]> {
	private int id;

	public RequestAnimesSimilar(int id) {
		super("animes/", ObjectAnime[].class);
		this.id = id;
	}

	public RequestAnimesSimilar(ShikimoriClient client, int id) {
		super(client, "animes/", ObjectAnime[].class);
		this.id = id;
	}

	@Override
	public String getMethod() {
		return super.getMethod() + id + "/similar";
	}
}
