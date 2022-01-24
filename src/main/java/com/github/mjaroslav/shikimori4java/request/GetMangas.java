package com.github.mjaroslav.shikimori4java.request;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.*;
import com.github.mjaroslav.shikimori4java.util.APIVersion;
import com.github.mjaroslav.shikimori4java.util.Utils;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.github.mjaroslav.shikimori4java.ShikimoriInfo.*;

public class GetMangas extends Request<Manga[]> {
    public GetMangas(@NotNull ShikimoriApp app) {
        super(app, METHOD_MANGAS_GET, Manga[].class, APIVersion.V1);
    }

    @NotNull
    public GetMangas setSearch(@NotNull String search) {
        setParam(PARAM_MANGAS_GET_SEARCH, search);
        return this;
    }

    @NotNull
    public GetMangas setLimit(@Range(from = 1, to = 50) int limit) {
        setParam(PARAM_MANGAS_GET_LIMIT, limit);
        return this;
    }

    @NotNull
    public GetMangas setPage(@Range(from = 0, to = 100000) int page) {
        setParam(PARAM_MANGAS_GET_PAGE, page);
        return this;
    }

    @NotNull
    public GetMangas setOrder(@NotNull String order) {
        setParam(PARAM_MANGAS_GET_ORDER, order);
        return this;
    }

    @NotNull
    public GetMangas setOrder(@NotNull MangaOrder order) {
        return setOrder(order.getValue());
    }

    @NotNull
    public GetMangas setKind(@NotNull String... kinds) {
        val result = String.join(",", kinds);
        setParam(PARAM_MANGAS_GET_KIND, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetMangas setKind(@NotNull MangaKind... kinds) {
        val result = Arrays.stream(kinds).map(MangaKind::getValue).collect(Collectors.joining(","));
        setParam(PARAM_MANGAS_GET_KIND, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetMangas setStatus(@NotNull String... statuses) {
        val result = String.join(",", statuses);
        setParam(PARAM_MANGAS_GET_STATUS, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetMangas setStatus(Status... statuses) {
        val result = Arrays.stream(statuses).map(Status::getValue).collect(Collectors.joining(","));
        setParam(PARAM_MANGAS_GET_STATUS, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetMangas setSeason(@NotNull String season) {
        setParam(PARAM_MANGAS_GET_SEASON, season);
        return this;
    }

    @NotNull
    public GetMangas setScore(@Range(from = 0, to = 10) float score) {
        setParam(PARAM_MANGAS_GET_SCORE, score);
        return this;
    }

    @NotNull
    public GetMangas setGenre(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam(PARAM_MANGAS_GET_GENRE, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetMangas setPublisher(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam(PARAM_MANGAS_GET_PUBLISHER, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetMangas setCensored(boolean censored) {
        setParam(PARAM_MANGAS_GET_CENSORED, censored);
        return this;
    }

    @NotNull
    public GetMangas setMylist(@NotNull String... types) {
        val result = String.join(",", types);
        setParam(PARAM_MANGAS_GET_MY_LIST, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetMangas setMylist(Type... types) {
        val result = Arrays.stream(types).map(Type::getValue).collect(Collectors.joining(","));
        setParam(PARAM_MANGAS_GET_MY_LIST, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetMangas setIds(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam(PARAM_MANGAS_GET_IDS, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetMangas setExcludeIds(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam(PARAM_MANGAS_GET_EXCLUDE_IDS, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }
}
