package com.github.mjaroslav.shikimori4java.request.animes;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectAnimeFull;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesId extends RequestBase<ObjectAnimeFull> {
    public RequestAnimesId(int id) {
        super("animes/" + id, ObjectAnimeFull.class);
    }

    public RequestAnimesId(ShikimoriApp app, int id) {
        super(app, "animes/" + id, ObjectAnimeFull.class);
    }
}
