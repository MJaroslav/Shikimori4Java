package com.github.mjaroslav.shikimori4java.auth;

import com.github.kevinsawicki.http.HttpRequest;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import static com.github.mjaroslav.shikimori4java.ShikimoriInfo.*;

@UtilityClass
public class Auth {
    @NotNull
    public HttpRequest createCodeRequest(@NotNull String clientId, @NotNull String clientSecret,
                                         @NotNull String redirectUri) {
        return HttpRequest.get(METHOD_AUTHORIZE, true, PARAM_CLIENT_ID, clientId, PARAM_CLIENT_SECRET, clientSecret,
                PARAM_REDIRECT_URI, redirectUri, PARAM_RESPONSE_TYPE, RESPONSE_TYPE_CODE);
    }

    @NotNull
    public HttpRequest createAuthorizationTokenRequest(@NotNull String clientId, @NotNull String clientSecret,
                                                       @NotNull String redirectUri, @NotNull String code,
                                                       @NotNull String appName) {
        return HttpRequest.post(METHOD_TOKEN, true, PARAM_CLIENT_ID, clientId, PARAM_CLIENT_SECRET, clientSecret,
                        PARAM_REDIRECT_URI, redirectUri, PARAM_GRANT_TYPE, GRANT_TYPE_AUTHORIZATION_CODE, PARAM_CODE, code)
                .userAgent(appName);
    }

    @NotNull
    public HttpRequest createRefreshTokenRequest(@NotNull String token, @NotNull String clientId,
                                                 @NotNull String clientSecret, @NotNull String appName) {
        return HttpRequest.post(METHOD_TOKEN, true, PARAM_GRANT_TYPE, GRANT_TYPE_REFRESH_TOKEN, PARAM_REFRESH_TOKEN,
                token, PARAM_CLIENT_SECRET, clientSecret, PARAM_CLIENT_ID, clientId).userAgent(appName);
    }
}
