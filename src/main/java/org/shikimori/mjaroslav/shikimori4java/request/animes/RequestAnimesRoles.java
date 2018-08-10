package org.shikimori.mjaroslav.shikimori4java.request.animes;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectRole;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesRoles extends RequestBase<ObjectRole[]> {
	public RequestAnimesRoles(int id) {
		super("animes/" + id + "/roles", ObjectRole[].class);
	}

	public RequestAnimesRoles(ShikimoriClient client, int id) {
		super(client, "animes/" + id + "/roles", ObjectRole[].class);
	}
}
