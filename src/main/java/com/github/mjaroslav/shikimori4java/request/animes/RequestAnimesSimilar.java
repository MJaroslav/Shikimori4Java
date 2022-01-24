package com.github.mjaroslav.shikimori4java.request.animes;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectAnime;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesSimilar extends RequestBase<ObjectAnime[]> {
    public RequestAnimesSimilar(ShikimoriApp app, int id) {
        super(app, "animes/" + id + "/similar", ObjectAnime[].class);
    }
}
