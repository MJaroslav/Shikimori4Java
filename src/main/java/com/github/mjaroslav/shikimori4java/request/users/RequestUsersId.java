package com.github.mjaroslav.shikimori4java.request.users;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectUserFull;
import com.github.mjaroslav.shikimori4java.request.RequestBase;

public class RequestUsersId extends RequestBase<ObjectUserFull> {
    public RequestUsersId(int id) {
        super("users/" + id, ObjectUserFull.class);
    }

    public RequestUsersId(ShikimoriApp app, int id) {
        super(app, "users/" + id, ObjectUserFull.class);
    }
}
