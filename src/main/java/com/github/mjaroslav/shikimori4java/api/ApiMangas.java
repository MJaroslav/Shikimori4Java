package com.github.mjaroslav.shikimori4java.api;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.*;
import com.github.mjaroslav.shikimori4java.request.RequestBase;
import com.github.mjaroslav.shikimori4java.request.RequestMangas;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

public class ApiMangas extends ApiBase {
    public ApiMangas(@NotNull ShikimoriApp app) {
        super(app);
    }

    @NotNull
    public RequestMangas pattern() {
        return new RequestMangas(app);
    }

    @NotNull
    public RequestMangas top() {
        return new RequestMangas(app).setLimit(50);
    }

    @NotNull
    public RequestMangas search(@NotNull String search) {
        return new RequestMangas(app).setSearch(search);
    }

    @NotNull
    public RequestMangas search(@NotNull String search, @Range(from = 1, to = 50) int limit) {
        return new RequestMangas(app).setSearch(search).setLimit(limit);
    }

    @NotNull
    public RequestBase<ObjectMangaFull> id(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "mangas/" + id, ObjectMangaFull.class);
    }

    @NotNull
    public RequestBase<ObjectManga[]> similar(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "mangas/" + id + "/similar", ObjectManga[].class);
    }

    @NotNull
    public RequestBase<ObjectRole[]> roles(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "mangas/" + id + "/roles", ObjectRole[].class);
    }

    @NotNull
    public RequestBase<ObjectRelation[]> related(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "mangas/" + id + "/related", ObjectRelation[].class);
    }

    @NotNull
    public RequestBase<ObjectFranchise> franchise(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "mangas/" + id + "/franchise", ObjectFranchise.class);
    }

    @NotNull
    public RequestBase<ObjectExternalLink[]> externalLink(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new RequestBase<>(app, "mangas/" + id + "/external_links", ObjectExternalLink[].class);
    }
}
