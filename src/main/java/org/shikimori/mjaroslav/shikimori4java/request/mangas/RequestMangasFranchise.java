package org.shikimori.mjaroslav.shikimori4java.request.mangas;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectFranchise;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasFranchise extends RequestBase<ObjectFranchise> {
	public RequestMangasFranchise(int id) {
		super("mangas/" + id + "/franchise", ObjectFranchise.class);
	}

	public RequestMangasFranchise(ShikimoriClient client, int id) {
		super(client, "mangas/" + id + "/franchise", ObjectFranchise.class);
	}
}
