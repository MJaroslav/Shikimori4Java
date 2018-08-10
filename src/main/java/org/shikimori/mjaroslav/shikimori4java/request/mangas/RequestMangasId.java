package org.shikimori.mjaroslav.shikimori4java.request.mangas;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectMangaFull;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasId extends RequestBase<ObjectMangaFull> {
	public RequestMangasId(int id) {
		super("mangas/" + id, ObjectMangaFull.class);
	}

	public RequestMangasId(ShikimoriApp app, int id) {
		super(app, "mangas/" + id, ObjectMangaFull.class);
	}
}
