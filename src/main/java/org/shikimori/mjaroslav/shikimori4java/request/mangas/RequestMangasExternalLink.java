package org.shikimori.mjaroslav.shikimori4java.request.mangas;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectExternalLink;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasExternalLink extends RequestBase<ObjectExternalLink[]> {
	public RequestMangasExternalLink(int id) {
		super("mangas/" + id + "/external_links", ObjectExternalLink[].class);
	}

	public RequestMangasExternalLink(ShikimoriClient client, int id) {
		super(client, "mangas/" + id + "/external_links", ObjectExternalLink[].class);
	}
}
