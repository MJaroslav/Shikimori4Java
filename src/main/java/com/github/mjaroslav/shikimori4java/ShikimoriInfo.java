package com.github.mjaroslav.shikimori4java;

public class ShikimoriInfo {
    public static final String URL_SHIKIMORI = "https://shikimori.one";
    public static final String URL_API_V1 = URL_SHIKIMORI + "/api";
    public static final String URL_API_V2 = URL_SHIKIMORI + "/api/v2";
    public static final String URL_AUTHORIZE = URL_SHIKIMORI + "/oauth/authorize";
    public static final String URL_TOKEN = URL_SHIKIMORI + "/oauth/token";

    public static final String PARAM_RESPONSE_TYPE = "response_type";
    public static final String PARAM_GRANT_TYPE = "grant_type";
    public static final String PARAM_CODE = "code";
    public static final String PARAM_REDIRECT_URI = "redirect_uri";
    public static final String PARAM_CLIENT_ID = "client_id";
    public static final String PARAM_CLIENT_SECRET = "client_secret";
    public static final String PARAM_REFRESH_TOKEN = "refresh_token";

    public static final String RESPONSE_TYPE_CODE = "code";
    public static final String REDIRECT_URI_DEFAULT = "urn:ietf:wg:oauth:2.0:oob";
    public static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
    public static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";

    public static final String METHOD_ANIMES_GET = "animes";
    public static final String METHOD_ANIMES_GET_ID = METHOD_ANIMES_GET + "/%s";
    public static final String METHOD_ANIMES_SIMILAR = METHOD_ANIMES_GET_ID + "/similar";
    public static final String METHOD_ANIMES_SCREENSHOTS = METHOD_ANIMES_GET_ID + "/screenshots";
    public static final String METHOD_ANIMES_ROLES = METHOD_ANIMES_GET_ID + "/roles";
    public static final String METHOD_ANIMES_RELATED = METHOD_ANIMES_GET_ID + "/related";
    public static final String METHOD_ANIMES_FRANCHISE = METHOD_ANIMES_GET_ID + "/franchise";
    public static final String METHOD_ANIMES_EXTERNAL_LINKS = METHOD_ANIMES_GET_ID + "/external_links";

    public static final String METHOD_MANGAS_GET = "mangas";
    public static final String METHOD_MANGAS_GET_ID = METHOD_MANGAS_GET + "/%s";
    public static final String METHOD_MANGAS_SIMILAR = METHOD_MANGAS_GET_ID + "/similar";
    public static final String METHOD_MANGAS_ROLES = METHOD_MANGAS_GET_ID + "/roles";
    public static final String METHOD_MANGAS_RELATED = METHOD_MANGAS_GET_ID + "/related";
    public static final String METHOD_MANGAS_FRANCHISE = METHOD_MANGAS_GET_ID + "/franchise";
    public static final String METHOD_MANGAS_EXTERNAL_LINKS = METHOD_MANGAS_GET_ID + "/external_links";

    public static final String METHOD_USERS_GET = "users";
    public static final String METHOD_USERS_GET_ID = METHOD_USERS_GET + "/%s";
    public static final String METHOD_USERS_INFO = METHOD_USERS_GET_ID + "/info";
    public static final String METHOD_USERS_WHOAMI = METHOD_USERS_GET + "/whoami";
    public static final String METHOD_USERS_SIGN_OUT = METHOD_USERS_GET + "/sign_out";
    public static final String METHOD_USERS_FRIENDS = METHOD_USERS_GET_ID + "/friends";
    public static final String METHOD_USERS_CLUBS = METHOD_USERS_GET_ID + "/clubs";
    public static final String METHOD_USERS_ANIME_RATES = METHOD_USERS_GET_ID + "/anime_rates";
    public static final String METHOD_USERS_MANGA_RATES = METHOD_USERS_GET_ID + "/manga_rates";
    public static final String METHOD_USERS_FAVOURITES = METHOD_USERS_GET_ID + "/favourites";
    public static final String METHOD_USERS_MESSAGES = METHOD_USERS_GET_ID + "/messages";
    public static final String METHOD_USERS_UNREAD_MESSAGES = METHOD_USERS_GET_ID + "/unread_messages";
    public static final String METHOD_USERS_HISTORY = METHOD_USERS_GET_ID + "/history";
    public static final String METHOD_USERS_BANS = METHOD_USERS_GET_ID + "/bans";

    public static final String PARAM_ANIMES_GET_SEARCH = "search";
    public static final String PARAM_ANIMES_GET_LIMIT = "limit";
    public static final String PARAM_ANIMES_GET_PAGE = "page";
    public static final String PARAM_ANIMES_GET_ORDER = "order";
    public static final String PARAM_ANIMES_GET_KIND = "kind";
    public static final String PARAM_ANIMES_GET_STATUS = "status";
    public static final String PARAM_ANIMES_GET_SEASON = "season";
    public static final String PARAM_ANIMES_GET_SCORE = "score";
    public static final String PARAM_ANIMES_GET_DURATION = "duration";
    public static final String PARAM_ANIMES_GET_RATING = "rating";
    public static final String PARAM_ANIMES_GET_GENRE = "genre";
    public static final String PARAM_ANIMES_GET_STUDIO = "studio";
    public static final String PARAM_ANIMES_GET_CENSORED = "censored";
    public static final String PARAM_ANIMES_GET_MY_LIST = "mylist";
    public static final String PARAM_ANIMES_GET_IDS = "ids";
    public static final String PARAM_ANIMES_GET_EXCLUDE_IDS = "exclude_ids";

    public static final String PARAM_MANGAS_GET_SEARCH = "search";
    public static final String PARAM_MANGAS_GET_LIMIT = "limit";
    public static final String PARAM_MANGAS_GET_PAGE = "page";
    public static final String PARAM_MANGAS_GET_ORDER = "order";
    public static final String PARAM_MANGAS_GET_KIND = "kind";
    public static final String PARAM_MANGAS_GET_STATUS = "status";
    public static final String PARAM_MANGAS_GET_SEASON = "season";
    public static final String PARAM_MANGAS_GET_SCORE = "score";
    public static final String PARAM_MANGAS_GET_DURATION = "duration";
    public static final String PARAM_MANGAS_GET_RATING = "rating";
    public static final String PARAM_MANGAS_GET_GENRE = "genre";
    public static final String PARAM_MANGAS_GET_PUBLISHER = "publisher";
    public static final String PARAM_MANGAS_GET_CENSORED = "censored";
    public static final String PARAM_MANGAS_GET_MY_LIST = "mylist";
    public static final String PARAM_MANGAS_GET_IDS = "ids";
    public static final String PARAM_MANGAS_GET_EXCLUDE_IDS = "exclude_ids";

    public static final String PARAM_USERS_GET_LIMIT = "limit";
    public static final String PARAM_USERS_GET_PAGE = "page";
}
