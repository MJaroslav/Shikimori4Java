package com.github.mjaroslav.shikimori4java.request.mangas;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectExternalLink;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasExternalLink extends RequestBase<ObjectExternalLink[]> {
    public RequestMangasExternalLink(ShikimoriApp app, int id) {
        super(app, "mangas/" + id + "/external_links", ObjectExternalLink[].class);
    }
}
