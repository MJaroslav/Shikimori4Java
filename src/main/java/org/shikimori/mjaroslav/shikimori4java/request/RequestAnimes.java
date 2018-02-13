package org.shikimori.mjaroslav.shikimori4java.request;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.responce.ResponceAnime;

public class RequestAnimes extends RequestBase<ResponceAnime[]> {
	public RequestAnimes() {
		super("animes", ResponceAnime[].class);
	}

	public RequestAnimes(ShikimoriClient client) {
		super(client, "animes", ResponceAnime[].class);
	}

	public RequestAnimes setSearch(String search) {
		setParam("search", search);
		return this;
	}

	public RequestAnimes setLimit(int limit) {
		setParam("limit", limit);
		return this;
	}

	public RequestAnimes setPage(int page) {
		setParam("page", page);
		return this;
	}

	public RequestAnimes setOrder(String order) {
		setParam("order", order);
		return this;
	}

	public RequestAnimes setKind(String kind) {
		setParam("kind", kind);
		return this;
	}

	public RequestAnimes setStatus(String status) {
		setParam("status", status);
		return this;
	}

	public RequestAnimes setSeason(String season) {
		setParam("season", season);
		return this;
	}

	public RequestAnimes setScore(int score) {
		setParam("score", score);
		return this;
	}

	public RequestAnimes setDuration(String duration) {
		setParam("duration", duration);
		return this;
	}

	public RequestAnimes setRating(String rating) {
		setParam("rating", rating);
		return this;
	}

	public RequestAnimes setGenre(int... ids) {
		String value = null;
		if (ids.length > 0) {
			value = String.valueOf(ids[0]);
			if (ids.length > 1)
				for (int id = 1; id < ids.length; id++)
					value += "," + ids[id];
		}
		setParam("genre", value);
		return this;
	}

	public RequestAnimes setStudio(int... ids) {
		String value = null;
		if (ids.length > 0) {
			value = String.valueOf(ids[0]);
			if (ids.length > 1)
				for (int id = 1; id < ids.length; id++)
					value += "," + ids[id];
		}
		setParam("studio", value);
		return this;
	}

	public RequestAnimes setCensored(boolean censored) {
		setParam("censored", censored);
		return this;
	}

	public RequestAnimes setMylist(String mylist) {
		setParam("mylist", mylist);
		return this;
	}

	public RequestAnimes setIds(int... ids) {
		String value = null;
		if (ids.length > 0) {
			value = String.valueOf(ids[0]);
			if (ids.length > 1)
				for (int id = 1; id < ids.length; id++)
					value += "," + ids[id];
		}
		setParam("ids", value);
		return this;
	}

	public RequestAnimes setExcludeIds(int... ids) {
		String value = null;
		if (ids.length > 0) {
			value = String.valueOf(ids[0]);
			if (ids.length > 1)
				for (int id = 1; id < ids.length; id++)
					value += "," + ids[id];
		}
		setParam("exclude_ids", value);
		return this;
	}

	public String getSearch() {
		return (String) getParam("search");
	}

	public int getLimit() {
		return (int) getParam("limit");
	}
}
