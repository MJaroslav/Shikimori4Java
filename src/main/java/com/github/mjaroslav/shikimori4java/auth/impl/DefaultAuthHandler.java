package com.github.mjaroslav.shikimori4java.auth.impl;

import com.github.mjaroslav.shikimori4java.auth.Auth;
import com.github.mjaroslav.shikimori4java.auth.AuthHandler;
import com.github.mjaroslav.shikimori4java.object.AccessToken;
import com.github.mjaroslav.shikimori4java.util.Utils;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

import java.awt.*;

public final class DefaultAuthHandler implements AuthHandler {
    @Getter
    @Setter
    @UnknownNullability
    private AccessToken token;

    @Override
    public boolean auth(@NotNull String clientId, @NotNull String clientSecret, @NotNull String redirectUri,
                        @NotNull String appName) {
        if (!Desktop.isDesktopSupported())
            return false;
        try {
            Desktop.getDesktop().browse(Auth.createCodeRequest(clientId, clientSecret, redirectUri).url().toURI());
            val code = String.valueOf(System.console().readLine("Enter code: "));
            val tokenRequest = Auth.createAuthorizationTokenRequest(clientId, clientSecret, redirectUri,
                    code, appName);
            val token = Utils.fromJson(tokenRequest.body(), AccessToken.class);
            if (token == null || token.hasError())
                return false;
            setToken(token);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    @Override
    public boolean isAuthorized() {
        return token != null && !token.hasError() && !token.isRefreshRequired();
    }

    @Override
    public boolean refreshToken(@NotNull String clientId, @NotNull String clientSecret, @NotNull String appName,
                                @NotNull String token) {
        val refreshRequest = Auth.createRefreshTokenRequest(token, clientId, clientSecret, appName);
        val refreshedToken = Utils.fromJson(refreshRequest.body(), AccessToken.class);
        if (refreshedToken != null && !refreshedToken.hasError()) {
            setToken(refreshedToken);
            return true;
        }
        return false;
    }
}
