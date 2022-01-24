package com.github.mjaroslav.shikimori4java.request.mangas;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectMangaFull;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasId extends RequestBase<ObjectMangaFull> {
    public RequestMangasId(ShikimoriApp app, int id) {
        super(app, "mangas/" + id, ObjectMangaFull.class);
    }
}
