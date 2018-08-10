package org.shikimori.mjaroslav.shikimori4java.request.animes;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectRelation;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesRelated extends RequestBase<ObjectRelation[]> {
	public RequestAnimesRelated(int id) {
		super("animes/" + id + "/related", ObjectRelation[].class);
	}

	public RequestAnimesRelated(ShikimoriClient client, int id) {
		super(client, "animes/" + id + "/related", ObjectRelation[].class);
	}
}
