package com.github.mjaroslav.shikimori4java.auth;

import com.github.mjaroslav.shikimori4java.object.AccessToken;
import com.github.mjaroslav.shikimori4java.throwable.login.LoginErrorException;
import com.github.mjaroslav.shikimori4java.util.Utils;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public interface AuthHandler {
    void auth(@NotNull String clientId, @NotNull String clientSecret, @NotNull String redirectUri,
              @NotNull String appName) throws LoginErrorException;

    @UnknownNullability
    AccessToken getToken();

    void setToken(@Nullable AccessToken token);

    default boolean isAuthorized() {
        val token = getToken();
        return token != null && !token.hasError() && !token.isRefreshRequired();
    }

    default boolean isRefreshRequired() {
        return getToken() != null && getToken().isRefreshRequired();
    }

    default void refreshToken(@NotNull String clientId, @NotNull String clientSecret, @NotNull String appName,
                              @NotNull String token) throws LoginErrorException {
        val refreshRequest = Auth.createRefreshTokenRequest(token, clientId, clientSecret, appName);
        val refreshedToken = Utils.fromJson(refreshRequest.body(), AccessToken.class);
        if (!refreshedToken.hasError())
            setToken(refreshedToken);
        else throw new LoginErrorException(refreshedToken);
    }
}
