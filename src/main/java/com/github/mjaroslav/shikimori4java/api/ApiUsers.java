package com.github.mjaroslav.shikimori4java.api;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ObjectUserFull;
import com.github.mjaroslav.shikimori4java.object.ObjectUserMe;
import com.github.mjaroslav.shikimori4java.request.RequestBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

public class ApiUsers extends ApiBase {
    public ApiUsers(@NotNull ShikimoriApp app) {
        super(app);
    }

    @NotNull
    public RequestBase<ObjectUserMe> whoami() {
        return new RequestBase<>(app, "users/whoami", ObjectUserMe.class);
    }

    @NotNull
    public RequestBase<ObjectUserFull> id(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "users/" + id, ObjectUserFull.class);
    }
}
