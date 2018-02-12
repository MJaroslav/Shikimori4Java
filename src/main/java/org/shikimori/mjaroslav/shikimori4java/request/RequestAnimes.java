package org.shikimori.mjaroslav.shikimori4java.request;

import java.util.ArrayList;

import org.shikimori.mjaroslav.shikimori4java.responce.ResponceAnime;
import org.shikimori.mjaroslav.shikimori4java.utils.Utils;

public class RequestAnimes extends RequestBase<ResponceAnime[]> {
	private String search;
	private int limit;

	public RequestAnimes() {
		super("animes", ResponceAnime[].class);
	}

	public RequestAnimes setSearch(String search) {
		this.search = search;
		return this;
	}

	public RequestAnimes setLimit(int limit) {
		this.limit = limit;
		return this;
	}

	public String getSearch() {
		return search;
	}

	public int getLimit() {
		return limit;
	}

	@Override
	public Object[] getParams() {
		ArrayList<Object> result = new ArrayList<Object>();
		if (Utils.stringNotEmpty(search)) {
			result.add("search");
			result.add(search);
		}
		if (limit > 0 && limit < 100000) {
			result.add("limit");
			result.add(limit);
		}
		return result.toArray(new Object[] {});
	}
}
