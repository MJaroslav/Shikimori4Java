package org.shikimori.mjaroslav.shikimori4java.request;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectExternalLink;

public class RequestAnimesExternalLink extends RequestBase<ObjectExternalLink[]> {
	private int id;

	public RequestAnimesExternalLink(int id) {
		super("animes/", ObjectExternalLink[].class);
		this.id = id;
	}

	public RequestAnimesExternalLink(ShikimoriClient client, int id) {
		super(client, "animes/", ObjectExternalLink[].class);
		this.id = id;
	}

	@Override
	public String getMethod() {
		return super.getMethod() + id + "/external_links";
	}
}
