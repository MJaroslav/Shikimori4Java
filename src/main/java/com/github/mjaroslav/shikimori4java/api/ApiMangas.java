package com.github.mjaroslav.shikimori4java.api;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.request.mangas.RequestMangas;
import com.github.mjaroslav.shikimori4java.request.mangas.RequestMangasExternalLink;
import com.github.mjaroslav.shikimori4java.request.mangas.RequestMangasFranchise;
import com.github.mjaroslav.shikimori4java.request.mangas.RequestMangasId;
import com.github.mjaroslav.shikimori4java.request.mangas.RequestMangasRelated;
import com.github.mjaroslav.shikimori4java.request.mangas.RequestMangasRoles;
import com.github.mjaroslav.shikimori4java.request.mangas.RequestMangasSimilar;

public class ApiMangas extends ApiBase {
    public ApiMangas(ShikimoriApp app) {
        super(app);
    }

    public RequestMangas pattern() {
        return new RequestMangas(getApp());
    }

    public RequestMangas top() {
        return new RequestMangas(getApp()).setLimit(50);
    }

    public RequestMangas search(String search) {
        return new RequestMangas(getApp()).setSearch(search);
    }

    public RequestMangas search(String search, int limit) {
        return new RequestMangas(getApp()).setSearch(search).setLimit(limit);
    }

    public RequestMangasId id(int id) {
        return new RequestMangasId(getApp(), id);
    }

    public RequestMangasSimilar similar(int id) {
        return new RequestMangasSimilar(getApp(), id);
    }

    public RequestMangasRoles roles(int id) {
        return new RequestMangasRoles(getApp(), id);
    }

    public RequestMangasRelated related(int id) {
        return new RequestMangasRelated(getApp(), id);
    }

    public RequestMangasFranchise franchise(int id) {
        return new RequestMangasFranchise(getApp(), id);
    }

    public RequestMangasExternalLink externalLink(int id) {
        return new RequestMangasExternalLink(getApp(), id);
    }
}
