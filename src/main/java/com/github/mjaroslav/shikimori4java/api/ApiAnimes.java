package com.github.mjaroslav.shikimori4java.api;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.*;
import com.github.mjaroslav.shikimori4java.request.RequestBase;
import com.github.mjaroslav.shikimori4java.request.RequestAnimes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

public class ApiAnimes extends ApiBase {
    public ApiAnimes(@NotNull ShikimoriApp app) {
        super(app);
    }

    @NotNull
    public RequestAnimes pattern() {
        return new RequestAnimes(app);
    }

    @NotNull
    public RequestAnimes top() {
        return pattern().setLimit(50);
    }

    @NotNull
    public RequestAnimes search(@NotNull String search) {
        return pattern().setSearch(search);
    }

    @NotNull
    public RequestAnimes search(@NotNull String search, @Range(from = 1, to = 50) int limit) {
        return pattern().setSearch(search).setLimit(limit);
    }

    @NotNull
    public RequestBase<ObjectAnimeFull> id(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "animes/" + id, ObjectAnimeFull.class);
    }

    @NotNull
    public RequestBase<ObjectAnime[]> similar(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "animes/" + id + "/similar", ObjectAnime[].class);
    }

    @NotNull
    public RequestBase<ObjectImage[]> screenshots(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "animes/" + id + "/screenshots", ObjectImage[].class);
    }

    @NotNull
    public RequestBase<ObjectRole[]> roles(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "animes/" + id + "/roles", ObjectRole[].class);
    }

    @NotNull
    public RequestBase<ObjectRelation[]> related(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "animes/" + id + "/related", ObjectRelation[].class);
    }

    @NotNull
    public RequestBase<ObjectFranchise> franchise(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "animes/" + id + "/franchise", ObjectFranchise.class);
    }

    @NotNull
    public RequestBase<ObjectExternalLink[]> externalLink(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "animes/" + id + "/external_links", ObjectExternalLink[].class);
    }
}
