package com.github.mjaroslav.shikimori4java.api;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.ClubMinimal;
import com.github.mjaroslav.shikimori4java.object.User;
import com.github.mjaroslav.shikimori4java.object.UserExtended;
import com.github.mjaroslav.shikimori4java.object.UserMinimal;
import com.github.mjaroslav.shikimori4java.request.GetUsers;
import com.github.mjaroslav.shikimori4java.request.Request;
import com.github.mjaroslav.shikimori4java.util.APIVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import static com.github.mjaroslav.shikimori4java.ShikimoriInfo.*;

// TODO
public class Users extends API {
    public Users(@NotNull ShikimoriApp app) {
        super(app);
    }

    @NotNull
    public GetUsers pattern() {
        return new GetUsers(app);
    }

    @NotNull
    public GetUsers get(@Range(from = 1, to = 100) int limit, @Range(from = 0, to = 100000) int page) {
        return pattern().setLimit(limit).setPage(page);
    }

    @NotNull
    public Request<User> whoami() {
        return new Request<>(app, METHOD_USERS_WHOAMI, User.class, APIVersion.V1);
    }

    @NotNull
    public Request<UserExtended> id(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_USERS_GET_ID, id), UserExtended.class, APIVersion.V1);
    }

    @NotNull
    public Request<User> info(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_USERS_INFO, id), User.class, APIVersion.V1);
    }

    @NotNull
    public Request<String> signOut() {
        return new Request<>(app, METHOD_USERS_SIGN_OUT, String.class, APIVersion.V1);
    }

    @NotNull
    public Request<UserMinimal[]> friends(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_USERS_FRIENDS, id), UserMinimal[].class, APIVersion.V1);
    }

    @NotNull
    public Request<ClubMinimal[]> clubs(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_USERS_CLUBS, id), ClubMinimal[].class, APIVersion.V1);
    }


}
