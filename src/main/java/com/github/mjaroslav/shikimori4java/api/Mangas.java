package com.github.mjaroslav.shikimori4java.api;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.*;
import com.github.mjaroslav.shikimori4java.request.GetMangas;
import com.github.mjaroslav.shikimori4java.request.Request;
import com.github.mjaroslav.shikimori4java.util.APIVersion;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import static com.github.mjaroslav.shikimori4java.ShikimoriInfo.*;

@RequiredArgsConstructor
public class Mangas {
    @NotNull
    private final ShikimoriApp app;

    @NotNull
    public GetMangas get() {
        return new GetMangas(app);
    }

    @NotNull
    public GetMangas top() {
        return new GetMangas(app).setLimit(50);
    }

    @NotNull
    public GetMangas search(@NotNull String search) {
        return new GetMangas(app).setSearch(search);
    }

    @NotNull
    public GetMangas search(@NotNull String search, @Range(from = 1, to = 50) int limit) {
        return new GetMangas(app).setSearch(search).setLimit(limit);
    }

    @NotNull
    public Request<MangaExtended> id(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_MANGAS_GET_ID, id), MangaExtended.class, APIVersion.V1, false);
    }

    @NotNull
    public Request<Manga[]> similar(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_MANGAS_SIMILAR, id), Manga[].class, APIVersion.V1, false);
    }

    @NotNull
    public Request<Role[]> roles(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_MANGAS_ROLES, id), Role[].class, APIVersion.V1, false);
    }

    @NotNull
    public Request<Relation[]> related(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_MANGAS_RELATED, id), Relation[].class, APIVersion.V1, false);
    }

    @NotNull
    public Request<Franchise> franchise(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_MANGAS_FRANCHISE, id), Franchise.class, APIVersion.V1, false);
    }

    @NotNull
    public Request<ExternalLink[]> externalLink(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_MANGAS_EXTERNAL_LINKS, id), ExternalLink[].class, APIVersion.V1, false);
    }
}
