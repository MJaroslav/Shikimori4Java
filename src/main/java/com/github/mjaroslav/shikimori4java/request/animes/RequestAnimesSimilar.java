package com.github.mjaroslav.shikimori4java.request.animes;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectAnime;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesSimilar extends RequestBase<ObjectAnime[]> {
    public RequestAnimesSimilar(int id) {
        super("animes/" + id + "/similar", ObjectAnime[].class);
    }

    public RequestAnimesSimilar(ShikimoriApp app, int id) {
        super(app, "animes/" + id + "/similar", ObjectAnime[].class);
    }
}
