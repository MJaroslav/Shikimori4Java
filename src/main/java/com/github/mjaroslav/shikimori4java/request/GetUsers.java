package com.github.mjaroslav.shikimori4java.request;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.UserMinimal;
import com.github.mjaroslav.shikimori4java.util.APIVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import static com.github.mjaroslav.shikimori4java.ShikimoriInfo.*;

public class GetUsers extends Request<UserMinimal[]> {
    public GetUsers(@NotNull ShikimoriApp app) {
        super(app, METHOD_USERS_GET, UserMinimal[].class, APIVersion.V1, false);
    }

    @NotNull
    public GetUsers setLimit(@Range(from = 1, to = 100) int limit) {
        setParam(PARAM_USERS_GET_LIMIT, limit);
        return this;
    }

    @NotNull
    public GetUsers setPage(@Range(from = 0, to = 1000000) int page) {
        setParam(PARAM_USERS_GET_PAGE, page);
        return this;
    }
}
