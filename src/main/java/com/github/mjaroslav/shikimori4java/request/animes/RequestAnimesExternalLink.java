package com.github.mjaroslav.shikimori4java.request.animes;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectExternalLink;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesExternalLink extends RequestBase<ObjectExternalLink[]> {
    public RequestAnimesExternalLink(int id) {
        super("animes/" + id + "/external_links", ObjectExternalLink[].class);
    }

    public RequestAnimesExternalLink(ShikimoriApp app, int id) {
        super(app, "animes/" + id + "/external_links", ObjectExternalLink[].class);
    }
}
