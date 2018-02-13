package org.shikimori.mjaroslav.shikimori4java.request;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectRelation;

public class RequestAnimesRelated extends RequestBase<ObjectRelation[]> {
	private int id;

	public RequestAnimesRelated(int id) {
		super("animes/", ObjectRelation[].class);
		this.id = id;
	}

	public RequestAnimesRelated(ShikimoriClient client, int id) {
		super(client, "animes/", ObjectRelation[].class);
		this.id = id;
	}

	@Override
	public String getMethod() {
		return super.getMethod() + id + "/related";
	}
}
