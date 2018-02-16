package org.shikimori.mjaroslav.shikimori4java.request.mangas;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectMangaFull;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasId extends RequestBase<ObjectMangaFull> {
	public RequestMangasId(int id) {
		super("mangas/" + id, ObjectMangaFull.class);
	}

	public RequestMangasId(ShikimoriClient client, int id) {
		super(client, "mangas/" + id, ObjectMangaFull.class);
	}
}
