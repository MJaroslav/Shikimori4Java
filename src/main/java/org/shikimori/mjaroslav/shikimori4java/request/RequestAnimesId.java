package org.shikimori.mjaroslav.shikimori4java.request;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectAnimeFull;

public class RequestAnimesId extends RequestBase<ObjectAnimeFull> {
	private int id;

	public RequestAnimesId(int id) {
		super("animes/", ObjectAnimeFull.class);
		this.id = id;
	}

	public RequestAnimesId(ShikimoriClient client, int id) {
		super(client, "animes/", ObjectAnimeFull.class);
		this.id = id;
	}

	@Override
	public String getMethod() {
		return super.getMethod() + id;
	}
}
