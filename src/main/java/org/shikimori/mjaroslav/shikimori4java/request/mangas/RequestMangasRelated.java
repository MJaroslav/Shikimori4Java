package org.shikimori.mjaroslav.shikimori4java.request.mangas;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectRelation;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasRelated extends RequestBase<ObjectRelation[]> {
	public RequestMangasRelated(int id) {
		super("mangas/" + id + "/related", ObjectRelation[].class);
	}

	public RequestMangasRelated(ShikimoriClient client, int id) {
		super(client, "mangas/" + id + "/related", ObjectRelation[].class);
	}
}
