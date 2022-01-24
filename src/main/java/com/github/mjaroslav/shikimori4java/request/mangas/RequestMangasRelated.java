package com.github.mjaroslav.shikimori4java.request.mangas;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectRelation;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasRelated extends RequestBase<ObjectRelation[]> {
    public RequestMangasRelated(ShikimoriApp app, int id) {
        super(app, "mangas/" + id + "/related", ObjectRelation[].class);
    }
}
