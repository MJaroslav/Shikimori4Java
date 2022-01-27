package com.github.mjaroslav.shikimori4java.api;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.*;
import com.github.mjaroslav.shikimori4java.request.GetAnimes;
import com.github.mjaroslav.shikimori4java.request.Request;
import com.github.mjaroslav.shikimori4java.util.APIVersion;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import static com.github.mjaroslav.shikimori4java.ShikimoriInfo.*;

@RequiredArgsConstructor
public class Animes {
    @NotNull
    private final ShikimoriApp app;

    @NotNull
    public GetAnimes get() {
        return new GetAnimes(app);
    }

    @NotNull
    public GetAnimes top() {
        return new GetAnimes(app).setLimit(50);
    }

    @NotNull
    public GetAnimes search(@NotNull String search) {
        return new GetAnimes(app).setSearch(search);
    }

    @NotNull
    public GetAnimes search(@NotNull String search, @Range(from = 1, to = 50) int limit) {
        return new GetAnimes(app).setSearch(search).setLimit(limit);
    }

    @NotNull
    public Request<AnimeExtended> id(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_ANIMES_GET_ID, id), AnimeExtended.class, APIVersion.V1, false);
    }

    @NotNull
    public Request<Anime[]> similar(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_ANIMES_SIMILAR, id), Anime[].class, APIVersion.V1, false);
    }

    @NotNull
    public Request<Image[]> screenshots(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_ANIMES_SCREENSHOTS, id), Image[].class, APIVersion.V1, false);
    }

    @NotNull
    public Request<Role[]> roles(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_ANIMES_ROLES, id), Role[].class, APIVersion.V1, false);
    }

    @NotNull
    public Request<Relation[]> related(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_ANIMES_RELATED, id), Relation[].class, APIVersion.V1, false);
    }

    @NotNull
    public Request<Franchise> franchise(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_ANIMES_FRANCHISE, id), Franchise.class, APIVersion.V1, false);
    }

    @NotNull
    public Request<ExternalLink[]> externalLink(@Range(from = 1, to = Integer.MAX_VALUE) int id) {
        return new Request<>(app, String.format(METHOD_ANIMES_EXTERNAL_LINKS, id), ExternalLink[].class, APIVersion.V1, false);
    }
}
