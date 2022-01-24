package com.github.mjaroslav.shikimori4java.request.mangas;

import java.util.ArrayList;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.request.RequestBase;
import com.github.mjaroslav.shikimori4java.object.EnumMangaKind;
import com.github.mjaroslav.shikimori4java.object.EnumMangaOrder;
import com.github.mjaroslav.shikimori4java.object.EnumStatus;
import com.github.mjaroslav.shikimori4java.object.EnumType;
import com.github.mjaroslav.shikimori4java.object.ObjectManga;

public class RequestMangas extends RequestBase<ObjectManga[]> {
    public RequestMangas(ShikimoriApp app) {
        super(app, "mangas", ObjectManga[].class);
    }

    public RequestMangas setSearch(String search) {
        setParam("search", search);
        return this;
    }

    public RequestMangas setLimit(int limit) {
        setParam("limit", limit);
        return this;
    }

    public RequestMangas setPage(int page) {
        setParam("page", page);
        return this;
    }

    public RequestMangas setOrder(String order) {
        setParam("order", order);
        return this;
    }

    public RequestMangas setOrder(EnumMangaOrder order) {
        return setOrder(order.getStringValue());
    }

    public RequestMangas setKind(String... kinds) {
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

    public RequestMangas setKind(EnumMangaKind... kinds) {
        ArrayList<String> value = new ArrayList<String>();
        for (EnumMangaKind kind : kinds)
            value.add(kind.getStringValue());
        return setKind(value.toArray(new String[0]));
    }

    public RequestMangas setStatus(String... statuses) {
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

    public RequestMangas setStatus(EnumStatus... statuses) {
        ArrayList<String> value = new ArrayList<String>();
        for (EnumStatus kind : statuses)
            value.add(kind.getStringValue());
        return setStatus(value.toArray(new String[0]));
    }

    public RequestMangas setSeason(String season) {
        setParam("season", season);
        return this;
    }

    public RequestMangas setScore(int score) {
        setParam("score", score);
        return this;
    }

    public RequestMangas setGenre(int... ids) {
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

    public RequestMangas setPublisher(int... ids) {
        String value = null;
        if (ids.length > 0) {
            value = String.valueOf(ids[0]);
            if (ids.length > 1)
                for (int id = 1; id < ids.length; id++)
                    value += "," + ids[id];
        }
        setParam("publisher", value);
        return this;
    }

    public RequestMangas setCensored(boolean censored) {
        setParam("censored", censored);
        return this;
    }

    public RequestMangas setMylist(String... types) {
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

    public RequestMangas setMylist(EnumType... types) {
        ArrayList<String> value = new ArrayList<String>();
        for (EnumType kind : types)
            value.add(kind.getStringValue());
        return setMylist(value.toArray(new String[0]));
    }

    public RequestMangas setIds(int... ids) {
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

    public RequestMangas setExcludeIds(int... ids) {
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
