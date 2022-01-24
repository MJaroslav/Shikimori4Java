package com.github.mjaroslav.shikimori4java.request.animes;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectImage;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesScreenshots extends RequestBase<ObjectImage[]> {
    public RequestAnimesScreenshots(ShikimoriApp app, int id) {
        super(app, "animes/" + id + "/screenshots", ObjectImage[].class);
    }
}
