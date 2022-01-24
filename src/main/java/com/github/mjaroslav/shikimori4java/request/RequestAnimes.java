package com.github.mjaroslav.shikimori4java.request;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.object.*;
import com.github.mjaroslav.shikimori4java.util.Utils;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RequestAnimes extends RequestBase<ObjectAnime[]> {
    public RequestAnimes(@NotNull ShikimoriApp app) {
        super(app, "animes", ObjectAnime[].class);
    }

    @NotNull
    public RequestAnimes setSearch(@NotNull String search) {
        setParam("search", search);
        return this;
    }

    @NotNull
    public RequestAnimes setLimit(@Range(from = 1, to = 50) int limit) {
        setParam("limit", limit);
        return this;
    }

    @NotNull
    public RequestAnimes setPage(@Range(from = 0, to = 1000000) int page) {
        setParam("page", page);
        return this;
    }

    @NotNull
    public RequestAnimes setOrder(@NotNull String order) {
        setParam("order", order);
        return this;
    }

    @NotNull
    public RequestAnimes setOrder(@NotNull EnumAnimeOrder order) {
        return setOrder(order.getValue());
    }

    @NotNull
    public RequestAnimes setKind(@NotNull String... kinds) {
        val result = String.join(",", kinds);
        setParam("kind", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestAnimes setKind(@NotNull EnumAnimeKind... kinds) {
        val result = Arrays.stream(kinds).map(EnumAnimeKind::getValue).collect(Collectors.joining(","));
        setParam("kind", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }


    @NotNull
    public RequestAnimes setStatus(@NotNull String... statuses) {
        val result = String.join(",", statuses);
        setParam("status", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestAnimes setStatus(@NotNull EnumStatus... statuses) {
        val result = Arrays.stream(statuses).map(EnumStatus::getValue).collect(Collectors.joining(","));
        setParam("status", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestAnimes setSeason(@NotNull String season) {
        setParam("season", season);
        return this;
    }

    @NotNull
    public RequestAnimes setScore(@Range(from = 0, to = 10) float score) {
        setParam("score", score);
        return this;
    }

    @NotNull
    public RequestAnimes setDuration(@NotNull String... durations) {
        val result = String.join(",", durations);
        setParam("duration", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestAnimes setDuration(@NotNull EnumDuration... durations) {
        val result = Arrays.stream(durations).map(EnumDuration::getValue).collect(Collectors.joining(","));
        setParam("duration", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestAnimes setRating(@NotNull String... ratings) {
        val result = String.join(",", ratings);
        setParam("rating", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestAnimes setRating(@NotNull EnumRating... ratings) {
        val result = Arrays.stream(ratings).map(EnumRating::getValue).collect(Collectors.joining(","));
        setParam("rating", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestAnimes setGenre(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam("genre", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestAnimes setStudio(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam("studio", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestAnimes setCensored(boolean censored) {
        setParam("censored", censored);
        return this;
    }

    @NotNull
    public RequestAnimes setMylist(@NotNull String... types) {
        val result = String.join(",", types);
        setParam("mylist", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestAnimes setMylist(@NotNull EnumType... types) {
        val result = Arrays.stream(types).map(EnumType::getValue).collect(Collectors.joining(","));
        setParam("mylist", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestAnimes setIds(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam("ids", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public RequestAnimes setExcludeIds(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam("exclude_ids", Utils.stringNotEmpty(result) ? result : null);
        return this;
    }
}
