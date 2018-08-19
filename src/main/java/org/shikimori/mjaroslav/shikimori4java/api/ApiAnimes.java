package org.shikimori.mjaroslav.shikimori4java.api;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimes;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesExternalLink;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesFranchise;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesId;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesRelated;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesRoles;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesScreenshots;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesSimilar;

public class ApiAnimes extends ApiBase {
    public ApiAnimes(ShikimoriApp app) {
        super(app);
    }

    public RequestAnimes pattern() {
        return new RequestAnimes(getApp());
    }

    public RequestAnimes top() {
        return pattern().setLimit(50);
    }

    public RequestAnimes search(String search) {
        return pattern().setSearch(search);
    }

    public RequestAnimes search(String search, int limit) {
        return pattern().setSearch(search).setLimit(limit);
    }

    public RequestAnimesId id(int id) {
        return new RequestAnimesId(getApp(), id);
    }

    public RequestAnimesSimilar similar(int id) {
        return new RequestAnimesSimilar(getApp(), id);
    }

    public RequestAnimesScreenshots screenshots(int id) {
        return new RequestAnimesScreenshots(getApp(), id);
    }

    public RequestAnimesRoles roles(int id) {
        return new RequestAnimesRoles(getApp(), id);
    }

    public RequestAnimesRelated related(int id) {
        return new RequestAnimesRelated(getApp(), id);
    }

    public RequestAnimesFranchise franchise(int id) {
        return new RequestAnimesFranchise(getApp(), id);
    }

    public RequestAnimesExternalLink externalLink(int id) {
        return new RequestAnimesExternalLink(getApp(), id);
    }
}
