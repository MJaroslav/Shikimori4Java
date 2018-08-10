package org.shikimori.mjaroslav.shikimori4java.request.animes;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectImage;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesScreenshots extends RequestBase<ObjectImage[]> {
	public RequestAnimesScreenshots(int id) {
		super("animes/" + id + "/screenshots", ObjectImage[].class);
	}

	public RequestAnimesScreenshots(ShikimoriClient client, int id) {
		super(client, "animes/" + id + "/screenshots", ObjectImage[].class);
	}
}
