package org.shikimori.mjaroslav.shikimori4java.request.animes;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectAnimeFull;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesId extends RequestBase<ObjectAnimeFull> {
	public RequestAnimesId(int id) {
		super("animes/" + id, ObjectAnimeFull.class);
	}

	public RequestAnimesId(ShikimoriClient client, int id) {
		super(client, "animes/" + id, ObjectAnimeFull.class);
	}
}
