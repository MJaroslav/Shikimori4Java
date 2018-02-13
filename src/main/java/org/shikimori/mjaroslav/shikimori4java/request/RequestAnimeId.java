package org.shikimori.mjaroslav.shikimori4java.request;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectAnimeFull;

public class RequestAnimeId extends RequestBase<ObjectAnimeFull> {
	private int id;

	public RequestAnimeId(int id) {
		super("animes/", ObjectAnimeFull.class);
		this.id = id;
	}

	public RequestAnimeId(ShikimoriClient client, int id) {
		super(client, "animes/", ObjectAnimeFull.class);
		this.id = id;
	}

	@Override
	public String getMethod() {
		return super.getMethod() + id;
	}
}
