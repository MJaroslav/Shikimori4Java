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

public class GetAnimes extends Request<Anime[]> {
    public GetAnimes(@NotNull ShikimoriApp app) {
        super(app, METHOD_ANIMES_GET, Anime[].class, APIVersion.V1, false);
    }

    @NotNull
    public GetAnimes setSearch(@NotNull String search) {
        setParam(PARAM_ANIMES_GET_SEARCH, search);
        return this;
    }

    @NotNull
    public GetAnimes setLimit(@Range(from = 1, to = 50) int limit) {
        setParam(PARAM_ANIMES_GET_LIMIT, limit);
        return this;
    }

    @NotNull
    public GetAnimes setPage(@Range(from = 0, to = 1000000) int page) {
        setParam(PARAM_ANIMES_GET_PAGE, page);
        return this;
    }

    @NotNull
    public GetAnimes setOrder(@NotNull String order) {
        setParam(PARAM_ANIMES_GET_ORDER, order);
        return this;
    }

    @NotNull
    public GetAnimes setOrder(@NotNull AnimeOrder order) {
        return setOrder(order.getValue());
    }

    @NotNull
    public GetAnimes setKind(@NotNull String... kinds) {
        val result = String.join(",", kinds);
        setParam(PARAM_ANIMES_GET_KIND, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetAnimes setKind(@NotNull AnimeKind... kinds) {
        val result = Arrays.stream(kinds).map(AnimeKind::getValue).collect(Collectors.joining(","));
        setParam(PARAM_ANIMES_GET_KIND, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }


    @NotNull
    public GetAnimes setStatus(@NotNull String... statuses) {
        val result = String.join(",", statuses);
        setParam(PARAM_ANIMES_GET_STATUS, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetAnimes setStatus(@NotNull Status... statuses) {
        val result = Arrays.stream(statuses).map(Status::getValue).collect(Collectors.joining(","));
        setParam(PARAM_ANIMES_GET_STATUS, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetAnimes setSeason(@NotNull String season) {
        setParam(PARAM_ANIMES_GET_SEASON, season);
        return this;
    }

    @NotNull
    public GetAnimes setScore(@Range(from = 0, to = 10) float score) {
        setParam(PARAM_ANIMES_GET_SCORE, score);
        return this;
    }

    @NotNull
    public GetAnimes setDuration(@NotNull String... durations) {
        val result = String.join(",", durations);
        setParam(PARAM_ANIMES_GET_DURATION, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetAnimes setDuration(@NotNull Duration... durations) {
        val result = Arrays.stream(durations).map(Duration::getValue).collect(Collectors.joining(","));
        setParam(PARAM_ANIMES_GET_DURATION, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetAnimes setRating(@NotNull String... ratings) {
        val result = String.join(",", ratings);
        setParam(PARAM_ANIMES_GET_RATING, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetAnimes setRating(@NotNull Rating... ratings) {
        val result = Arrays.stream(ratings).map(Rating::getValue).collect(Collectors.joining(","));
        setParam(PARAM_ANIMES_GET_RATING, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetAnimes setGenre(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam(PARAM_ANIMES_GET_GENRE, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetAnimes setStudio(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam(PARAM_ANIMES_GET_STUDIO, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetAnimes setCensored(boolean censored) {
        setParam(PARAM_ANIMES_GET_CENSORED, censored);
        return this;
    }

    @NotNull
    public GetAnimes setMylist(@NotNull String... types) {
        val result = String.join(",", types);
        setParam(PARAM_ANIMES_GET_MY_LIST, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetAnimes setMylist(@NotNull Type... types) {
        val result = Arrays.stream(types).map(Type::getValue).collect(Collectors.joining(","));
        setParam(PARAM_ANIMES_GET_MY_LIST, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetAnimes setIds(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam(PARAM_ANIMES_GET_IDS, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }

    @NotNull
    public GetAnimes setExcludeIds(int... ids) {
        val result = Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(","));
        setParam(PARAM_ANIMES_GET_EXCLUDE_IDS, Utils.stringNotEmpty(result) ? result : null);
        return this;
    }
}
