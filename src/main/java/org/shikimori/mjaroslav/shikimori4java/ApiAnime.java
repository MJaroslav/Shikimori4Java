package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimes;
import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimesExternalLink;
import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimesFranchise;
import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimesId;
import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimesRelated;
import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimesRoles;
import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimesScreenshots;
import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimesSimilar;

public class ApiAnime {
	private ShikimoriApi api;

	public ApiAnime(ShikimoriApi api) {
		this.api = api;
	}

	public RequestAnimes list() {
		return new RequestAnimes(api.getClient());
	}

	public RequestAnimesId id(int id) {
		return new RequestAnimesId(api.getClient(), id);
	}

	public RequestAnimesSimilar similar(int id) {
		return new RequestAnimesSimilar(api.getClient(), id);
	}

	public RequestAnimesScreenshots screenshots(int id) {
		return new RequestAnimesScreenshots(api.getClient(), id);
	}

	public RequestAnimesRoles roles(int id) {
		return new RequestAnimesRoles(api.getClient(), id);
	}

	public RequestAnimesRelated related(int id) {
		return new RequestAnimesRelated(api.getClient(), id);
	}

	public RequestAnimesFranchise franchise(int id) {
		return new RequestAnimesFranchise(api.getClient(), id);
	}

	public RequestAnimesExternalLink externalLink(int id) {
		return new RequestAnimesExternalLink(api.getClient(), id);
	}
}
