package org.shikimori.mjaroslav.shikimori4java.core;

public class ShikimoriInfo {
    public static final String SHIKIMORI = "https://shikimori.org";
    public static final String AUTHORIZE = SHIKIMORI + "/oauth/authorize";
    public static final String API = SHIKIMORI + "/api";
    public static final String TOKEN = SHIKIMORI + "/oauth/token";
    public static final String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
    public static final String RESPONSE_TYPE = "code";
    public static final String GRANT_TYPE_CODE = "authorization_code";
    public static final String GRANT_TYPE_REFRESH = "refresh_token";
}
