package org.shikimori.mjaroslav.shikimori4java.request.animes;

import java.util.ArrayList;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.EnumAnimeKind;
import org.shikimori.mjaroslav.shikimori4java.object.EnumAnimeOrder;
import org.shikimori.mjaroslav.shikimori4java.object.EnumDuration;
import org.shikimori.mjaroslav.shikimori4java.object.EnumRating;
import org.shikimori.mjaroslav.shikimori4java.object.EnumStatus;
import org.shikimori.mjaroslav.shikimori4java.object.EnumType;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectManga;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestAnimes extends RequestBase<ObjectManga[]> {
	public RequestAnimes() {
		super("animes", ObjectManga[].class);
	}

	public RequestAnimes(ShikimoriClient client) {
		super(client, "animes", ObjectManga[].class);
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

	public RequestAnimes setOrder(EnumAnimeOrder order) {
		return setOrder(order.getStringValue());
	}

	public RequestAnimes setKind(String... kinds) {
		String value = null;
		if (kinds.length > 0) {
			value = String.valueOf(kinds[0]);
			if (kinds.length > 1)
				for (int id = 1; id < kinds.length; id++)
					value += "," + kinds[id];
		}
		setParam("kind", value);
		return this;
	}

	public RequestAnimes setKind(EnumAnimeKind... kinds) {
		ArrayList<String> value = new ArrayList<String>();
		for (EnumAnimeKind kind : kinds)
			value.add(kind.getStringValue());
		return setKind(value.toArray(new String[0]));
	}

	public RequestAnimes setStatus(String... statuses) {
		String value = null;
		if (statuses.length > 0) {
			value = String.valueOf(statuses[0]);
			if (statuses.length > 1)
				for (int id = 1; id < statuses.length; id++)
					value += "," + statuses[id];
		}
		setParam("status", value);
		return this;
	}

	public RequestAnimes setStatus(EnumStatus... statuses) {
		ArrayList<String> value = new ArrayList<String>();
		for (EnumStatus kind : statuses)
			value.add(kind.getStringValue());
		return setStatus(value.toArray(new String[0]));
	}

	public RequestAnimes setSeason(String season) {
		setParam("season", season);
		return this;
	}

	public RequestAnimes setScore(int score) {
		setParam("score", score);
		return this;
	}

	public RequestAnimes setDuration(String... durations) {
		String value = null;
		if (durations.length > 0) {
			value = String.valueOf(durations[0]);
			if (durations.length > 1)
				for (int id = 1; id < durations.length; id++)
					value += "," + durations[id];
		}
		setParam("duration", value);
		return this;
	}

	public RequestAnimes setDuration(EnumDuration... durations) {
		ArrayList<String> value = new ArrayList<String>();
		for (EnumDuration kind : durations)
			value.add(kind.getStringValue());
		return setStatus(value.toArray(new String[0]));
	}

	public RequestAnimes setRating(String... ratings) {
		String value = null;
		if (ratings.length > 0) {
			value = String.valueOf(ratings[0]);
			if (ratings.length > 1)
				for (int id = 1; id < ratings.length; id++)
					value += "," + ratings[id];
		}
		setParam("rating", value);
		return this;
	}

	public RequestAnimes setRating(EnumRating... ratings) {
		ArrayList<String> value = new ArrayList<String>();
		for (EnumRating kind : ratings)
			value.add(kind.getStringValue());
		return setRating(value.toArray(new String[0]));
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

	public RequestAnimes setMylist(String... types) {
		String value = null;
		if (types.length > 0) {
			value = String.valueOf(types[0]);
			if (types.length > 1)
				for (int id = 1; id < types.length; id++)
					value += "," + types[id];
		}
		setParam("mylist", value);
		return this;
	}

	public RequestAnimes setMylist(EnumType... types) {
		ArrayList<String> value = new ArrayList<String>();
		for (EnumType kind : types)
			value.add(kind.getStringValue());
		return setMylist(value.toArray(new String[0]));
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
}
