package com.github.mjaroslav.shikimori4java.request.mangas;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectRole;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestMangasRoles extends RequestBase<ObjectRole[]> {
    public RequestMangasRoles(int id) {
        super("mangas/" + id + "/roles", ObjectRole[].class);
    }

    public RequestMangasRoles(ShikimoriApp app, int id) {
        super(app, "mangas/" + id + "/roles", ObjectRole[].class);
    }
}
