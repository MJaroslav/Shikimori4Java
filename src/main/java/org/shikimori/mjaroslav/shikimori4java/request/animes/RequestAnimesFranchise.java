package org.shikimori.mjaroslav.shikimori4java.request.animes;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectFranchise;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesFranchise extends RequestBase<ObjectFranchise> {
    public RequestAnimesFranchise(int id) {
        super("animes/" + id + "/franchise", ObjectFranchise.class);
    }

    public RequestAnimesFranchise(ShikimoriApp app, int id) {
        super(app, "animes/" + id + "/franchise", ObjectFranchise.class);
    }
}
