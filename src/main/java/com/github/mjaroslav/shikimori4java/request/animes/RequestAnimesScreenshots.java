package com.github.mjaroslav.shikimori4java.request.animes;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectImage;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesScreenshots extends RequestBase<ObjectImage[]> {
    public RequestAnimesScreenshots(int id) {
        super("animes/" + id + "/screenshots", ObjectImage[].class);
    }

    public RequestAnimesScreenshots(ShikimoriApp app, int id) {
        super(app, "animes/" + id + "/screenshots", ObjectImage[].class);
    }
}
