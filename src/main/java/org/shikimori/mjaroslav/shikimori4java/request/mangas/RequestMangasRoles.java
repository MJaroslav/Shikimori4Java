package org.shikimori.mjaroslav.shikimori4java.request.mangas;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectRole;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasRoles extends RequestBase<ObjectRole[]> {
	public RequestMangasRoles(int id) {
		super("mangas/" + id + "/roles", ObjectRole[].class);
	}

	public RequestMangasRoles(ShikimoriClient client, int id) {
		super(client, "mangas/" + id + "/roles", ObjectRole[].class);
	}
}
