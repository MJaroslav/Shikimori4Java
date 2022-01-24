package com.github.mjaroslav.shikimori4java;

public class ShikimoriInfo {
    public static final String URL_SHIKIMORI = "https://shikimori.one";
    public static final String URL_API = URL_SHIKIMORI + "/api";

    public static final String METHOD_AUTHORIZE = URL_SHIKIMORI + "/oauth/authorize";
    public static final String METHOD_TOKEN = URL_SHIKIMORI + "/oauth/token";

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

    public static final String HEADER_AUTHORIZATION = "Authorization";
}
