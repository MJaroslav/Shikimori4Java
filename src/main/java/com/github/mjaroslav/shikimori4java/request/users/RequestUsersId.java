package com.github.mjaroslav.shikimori4java.request.users;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectUserFull;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestUsersId extends RequestBase<ObjectUserFull> {
    public RequestUsersId(ShikimoriApp app, int id) {
        super(app, "users/" + id, ObjectUserFull.class);
    }
}
