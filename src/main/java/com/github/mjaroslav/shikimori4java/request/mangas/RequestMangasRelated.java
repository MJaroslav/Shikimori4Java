package com.github.mjaroslav.shikimori4java.request.mangas;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectRelation;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasRelated extends RequestBase<ObjectRelation[]> {
    public RequestMangasRelated(int id) {
        super("mangas/" + id + "/related", ObjectRelation[].class);
    }

    public RequestMangasRelated(ShikimoriApp app, int id) {
        super(app, "mangas/" + id + "/related", ObjectRelation[].class);
    }
}
