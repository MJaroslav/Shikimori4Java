package org.shikimori.mjaroslav.shikimori4java.request.animes;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectExternalLink;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesExternalLink extends RequestBase<ObjectExternalLink[]> {
	public RequestAnimesExternalLink(int id) {
		super("animes/" + id + "/external_links", ObjectExternalLink[].class);
	}

	public RequestAnimesExternalLink(ShikimoriClient client, int id) {
		super(client, "animes/" + id + "/external_links", ObjectExternalLink[].class);
	}
}
