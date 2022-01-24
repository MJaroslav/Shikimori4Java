package com.github.mjaroslav.shikimori4java.auth;

import com.github.mjaroslav.shikimori4java.object.AccessToken;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public interface AuthHandler {
    boolean auth(@NotNull String clientId, @NotNull String clientSecret, @NotNull String redirectUri,
                 @NotNull String appName);

    @UnknownNullability
    AccessToken getToken();

    void setToken(@Nullable AccessToken token);

    boolean isAuthorized();

    default boolean isRefreshRequired() {
        return getToken() != null && getToken().isRefreshRequired();
    }

    boolean refreshToken(@NotNull String clientId, @NotNull String clientSecret, @NotNull String appName,
                         @NotNull String token);
}
