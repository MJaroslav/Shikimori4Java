package com.github.mjaroslav.shikimori4java.request;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.*;
import com.github.mjaroslav.shikimori4java.util.Utils;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RequestMangas extends RequestBase<ObjectManga[]> {
    public RequestMangas(@NotNull ShikimoriApp app) {
        super(app, "mangas", ObjectManga[].class);
    }

    @NotNull
    public RequestMangas setSearch(@NotNull String search) {
        setParam("search", search);
        return this;
    }

    @NotNull
    public RequestMangas setLimit(@Range(from = 1, to = 50) int limit) {
        setParam("limit", limit);
        return this;
    }

    @NotNull
    public RequestMangas setPage(@Range(from = 0, to = 100000) int page) {
        setParam("page", page);
        return this;
    }

    @NotNull
    public RequestMangas setOrder(@NotNull String order) {
        setParam("order", order);
        return this;
    }

    @NotNull
    public RequestMangas setOrder(@NotNull EnumMangaOrder order) {
        return setOrder(order.getValue());
    }

    @NotNull
    public RequestMangas setKind(@NotNull String... kinds) {
        val result = String.join(",", kinds);
        setParam("kind", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestMangas setKind(@NotNull EnumMangaKind... kinds) {
        val result = Arrays.stream(kinds).map(EnumMangaKind::getValue).collect(Collectors.joining(","));
        setParam("kind", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestMangas setStatus(@NotNull String... statuses) {
        val result = String.join(",", statuses);
        setParam("status", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestMangas setStatus(EnumStatus... statuses) {
        val result = Arrays.stream(statuses).map(EnumStatus::getValue).collect(Collectors.joining(","));
        setParam("status", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestMangas setSeason(@NotNull String season) {
        setParam("season", season);
        return this;
    }

    @NotNull
    public RequestMangas setScore(@Range(from = 0, to = 10) float score) {
        setParam("score", score);
        return this;
    }

    @NotNull
    public RequestMangas setGenre(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam("genre", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestMangas setPublisher(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam("publisher", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestMangas setCensored(boolean censored) {
        setParam("censored", censored);
        return this;
    }

    @NotNull
    public RequestMangas setMylist(@NotNull String... types) {
        val result = String.join(",", types);
        setParam("mylist", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestMangas setMylist(EnumType... types) {
        val result = Arrays.stream(types).map(EnumType::getValue).collect(Collectors.joining(","));
        setParam("mylist", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestMangas setIds(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam("ids", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestMangas setExcludeIds(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam("exclude_ids", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }
}
