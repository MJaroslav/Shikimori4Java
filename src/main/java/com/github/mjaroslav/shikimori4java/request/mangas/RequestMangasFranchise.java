package com.github.mjaroslav.shikimori4java.request.mangas;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectFranchise;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasFranchise extends RequestBase<ObjectFranchise> {
    public RequestMangasFranchise(int id) {
        super("mangas/" + id + "/franchise", ObjectFranchise.class);
    }

    public RequestMangasFranchise(ShikimoriApp app, int id) {
        super(app, "mangas/" + id + "/franchise", ObjectFranchise.class);
    }
}
