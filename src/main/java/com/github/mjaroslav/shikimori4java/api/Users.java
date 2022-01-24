package com.github.mjaroslav.shikimori4java.api;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.UserExtended;
import com.github.mjaroslav.shikimori4java.object.UserMe;
import com.github.mjaroslav.shikimori4java.request.Request;
import com.github.mjaroslav.shikimori4java.util.APIVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

public class Users extends API {
    public Users(@NotNull ShikimoriApp app) {
        super(app);
    }

    @NotNull
    public Request<UserMe> whoami() {
        return new Request<>(app, "users/whoami", UserMe.class, APIVersion.V1);
    }

    @NotNull
    public Request<UserExtended> id(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, "users/" + id, UserExtended.class, APIVersion.V1);
    }
}
