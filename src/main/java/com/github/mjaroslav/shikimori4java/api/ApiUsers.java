package com.github.mjaroslav.shikimori4java.api;

import com.github.mjaroslav.shikimori4java.request.users.RequestUsersId;
import com.github.mjaroslav.shikimori4java.request.users.RequestUsersWhoami;
import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;

public class ApiUsers extends ApiBase {
    public ApiUsers(ShikimoriApp app) {
        super(app);
    }

    public RequestUsersWhoami whoami() {
        return new RequestUsersWhoami(getApp());
    }

    public RequestUsersId id(int id) {
        return new RequestUsersId(getApp(), id);
    }
}
