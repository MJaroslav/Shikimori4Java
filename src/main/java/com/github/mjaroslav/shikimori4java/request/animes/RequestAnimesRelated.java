package com.github.mjaroslav.shikimori4java.request.animes;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectRelation;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesRelated extends RequestBase<ObjectRelation[]> {
    public RequestAnimesRelated(int id) {
        super("animes/" + id + "/related", ObjectRelation[].class);
    }

    public RequestAnimesRelated(ShikimoriApp app, int id) {
        super(app, "animes/" + id + "/related", ObjectRelation[].class);
    }
}
