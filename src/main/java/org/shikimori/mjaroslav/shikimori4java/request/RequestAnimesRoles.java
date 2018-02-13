package org.shikimori.mjaroslav.shikimori4java.request;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectRole;

public class RequestAnimesRoles extends RequestBase<ObjectRole[]> {
	private int id;

	public RequestAnimesRoles(int id) {
		super("animes/", ObjectRole[].class);
		this.id = id;
	}

	public RequestAnimesRoles(ShikimoriClient client, int id) {
		super(client, "animes/", ObjectRole[].class);
		this.id = id;
	}

	@Override
	public String getMethod() {
		return super.getMethod() + id + "/roles";
	}
}
