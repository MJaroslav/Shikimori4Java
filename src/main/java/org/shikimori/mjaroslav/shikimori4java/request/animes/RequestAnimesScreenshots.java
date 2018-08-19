package org.shikimori.mjaroslav.shikimori4java.request.animes;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectImage;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesScreenshots extends RequestBase<ObjectImage[]> {
    public RequestAnimesScreenshots(int id) {
        super("animes/" + id + "/screenshots", ObjectImage[].class);
    }

    public RequestAnimesScreenshots(ShikimoriApp app, int id) {
        super(app, "animes/" + id + "/screenshots", ObjectImage[].class);
    }
}
