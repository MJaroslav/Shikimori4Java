package org.shikimori.mjaroslav.shikimori4java.api;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriApi;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimes;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesExternalLink;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesFranchise;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesId;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesRelated;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesRoles;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesScreenshots;
import org.shikimori.mjaroslav.shikimori4java.request.animes.RequestAnimesSimilar;

public class ApiAnimes extends ApiBase {
	public ApiAnimes(ShikimoriApi api) {
		super(api);
	}

	public RequestAnimes pattern() {
		return new RequestAnimes(getClient());
	}

	public RequestAnimes top() {
		return new RequestAnimes(getClient()).setLimit(50);
	}

	public RequestAnimes search(String search) {
		return new RequestAnimes(getClient()).setSearch(search);
	}

	public RequestAnimes search(String search, int limit) {
		return new RequestAnimes(getClient()).setSearch(search).setLimit(limit);
	}

	public RequestAnimesId id(int id) {
		return new RequestAnimesId(getClient(), id);
	}

	public RequestAnimesSimilar similar(int id) {
		return new RequestAnimesSimilar(getClient(), id);
	}

	public RequestAnimesScreenshots screenshots(int id) {
		return new RequestAnimesScreenshots(getClient(), id);
	}

	public RequestAnimesRoles roles(int id) {
		return new RequestAnimesRoles(getClient(), id);
	}

	public RequestAnimesRelated related(int id) {
		return new RequestAnimesRelated(getClient(), id);
	}

	public RequestAnimesFranchise franchise(int id) {
		return new RequestAnimesFranchise(getClient(), id);
	}

	public RequestAnimesExternalLink externalLink(int id) {
		return new RequestAnimesExternalLink(getClient(), id);
	}
}
