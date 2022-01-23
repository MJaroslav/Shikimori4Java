package com.github.mjaroslav.shikimori4java.request.animes;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectRole;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimesRoles extends RequestBase<ObjectRole[]> {
    public RequestAnimesRoles(int id) {
        super("animes/" + id + "/roles", ObjectRole[].class);
    }

    public RequestAnimesRoles(ShikimoriApp app, int id) {
        super(app, "animes/" + id + "/roles", ObjectRole[].class);
    }
}
