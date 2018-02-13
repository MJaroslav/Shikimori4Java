package org.shikimori.mjaroslav.shikimori4java.request;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectFranchise;

public class RequestAnimesFranchise extends RequestBase<ObjectFranchise> {
	private int id;

	public RequestAnimesFranchise(int id) {
		super("animes/", ObjectFranchise.class);
		this.id = id;
	}

	public RequestAnimesFranchise(ShikimoriClient client, int id) {
		super(client, "animes/", ObjectFranchise.class);
		this.id = id;
	}

	@Override
	public String getMethod() {
		return super.getMethod() + id + "/franchise";
	}
}
