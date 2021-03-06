package org.shikimori.mjaroslav.shikimori4java.request.mangas;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectManga;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasSimilar extends RequestBase<ObjectManga[]> {
    public RequestMangasSimilar(int id) {
        super("mangas/" + id + "/similar", ObjectManga[].class);
    }

    public RequestMangasSimilar(ShikimoriApp app, int id) {
        super(app, "mangas/" + id + "/similar", ObjectManga[].class);
    }
}
