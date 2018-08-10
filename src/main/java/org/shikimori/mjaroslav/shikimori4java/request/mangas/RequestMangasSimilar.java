package org.shikimori.mjaroslav.shikimori4java.request.mangas;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectManga;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasSimilar extends RequestBase<ObjectManga[]> {
	public RequestMangasSimilar(int id) {
		super("mangas/" + id + "/similar", ObjectManga[].class);
	}

	public RequestMangasSimilar(ShikimoriClient client, int id) {
		super(client, "mangas/" + id + "/similar", ObjectManga[].class);
	}
}
