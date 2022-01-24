package com.github.mjaroslav.shikimori4java.request.mangas;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectRole;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasRoles extends RequestBase<ObjectRole[]> {
    public RequestMangasRoles(ShikimoriApp app, int id) {
        super(app, "mangas/" + id + "/roles", ObjectRole[].class);
    }
}
