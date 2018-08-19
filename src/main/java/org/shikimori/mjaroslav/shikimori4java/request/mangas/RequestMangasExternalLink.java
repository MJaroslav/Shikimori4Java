package org.shikimori.mjaroslav.shikimori4java.request.mangas;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectExternalLink;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasExternalLink extends RequestBase<ObjectExternalLink[]> {
    public RequestMangasExternalLink(int id) {
        super("mangas/" + id + "/external_links", ObjectExternalLink[].class);
    }

    public RequestMangasExternalLink(ShikimoriApp app, int id) {
        super(app, "mangas/" + id + "/external_links", ObjectExternalLink[].class);
    }
}
