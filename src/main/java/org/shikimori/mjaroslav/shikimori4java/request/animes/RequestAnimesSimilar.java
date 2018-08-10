package org.shikimori.mjaroslav.shikimori4java.request.animes;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectAnime;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesSimilar extends RequestBase<ObjectAnime[]> {
	public RequestAnimesSimilar(int id) {
		super("animes/" + id + "/similar", ObjectAnime[].class);
	}

	public RequestAnimesSimilar(ShikimoriClient client, int id) {
		super(client, "animes/" + id + "/similar", ObjectAnime[].class);
	}
}
