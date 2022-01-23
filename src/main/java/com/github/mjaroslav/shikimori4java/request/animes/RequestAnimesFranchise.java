package com.github.mjaroslav.shikimori4java.request.animes;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectFranchise;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesFranchise extends RequestBase<ObjectFranchise> {
    public RequestAnimesFranchise(int id) {
        super("animes/" + id + "/franchise", ObjectFranchise.class);
    }

    public RequestAnimesFranchise(ShikimoriApp app, int id) {
        super(app, "animes/" + id + "/franchise", ObjectFranchise.class);
    }
}
