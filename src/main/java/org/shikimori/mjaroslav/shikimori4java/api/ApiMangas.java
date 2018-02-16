package org.shikimori.mjaroslav.shikimori4java.api;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriApi;
import org.shikimori.mjaroslav.shikimori4java.request.mangas.RequestMangas;
import org.shikimori.mjaroslav.shikimori4java.request.mangas.RequestMangasExternalLink;
import org.shikimori.mjaroslav.shikimori4java.request.mangas.RequestMangasFranchise;
import org.shikimori.mjaroslav.shikimori4java.request.mangas.RequestMangasId;
import org.shikimori.mjaroslav.shikimori4java.request.mangas.RequestMangasRelated;
import org.shikimori.mjaroslav.shikimori4java.request.mangas.RequestMangasRoles;
import org.shikimori.mjaroslav.shikimori4java.request.mangas.RequestMangasSimilar;

public class ApiMangas extends ApiBase {
	public ApiMangas(ShikimoriApi api) {
		super(api);
	}

	public RequestMangas top() {
		return new RequestMangas(getClient()).setLimit(50);
	}

	public RequestMangas search(String search) {
		return new RequestMangas(getClient()).setSearch(search);
	}

	public RequestMangas search(String search, int limit) {
		return new RequestMangas(getClient()).setSearch(search).setLimit(limit);
	}

	public RequestMangasId id(int id) {
		return new RequestMangasId(getClient(), id);
	}

	public RequestMangasSimilar similar(int id) {
		return new RequestMangasSimilar(getClient(), id);
	}

	public RequestMangasRoles roles(int id) {
		return new RequestMangasRoles(getClient(), id);
	}

	public RequestMangasRelated related(int id) {
		return new RequestMangasRelated(getClient(), id);
	}

	public RequestMangasFranchise franchise(int id) {
		return new RequestMangasFranchise(getClient(), id);
	}

	public RequestMangasExternalLink externalLink(int id) {
		return new RequestMangasExternalLink(getClient(), id);
	}
}
