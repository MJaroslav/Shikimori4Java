package com.github.mjaroslav.shikimori4java.request.users;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectUserMe;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestUsersWhoami extends RequestBase<ObjectUserMe> {
    public RequestUsersWhoami(ShikimoriApp app) {
        super(app, "users/whoami", ObjectUserMe.class);
    }
}
