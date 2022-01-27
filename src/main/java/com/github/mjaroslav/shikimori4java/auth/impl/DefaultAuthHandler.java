package com.github.mjaroslav.shikimori4java.auth.impl;

import com.github.mjaroslav.shikimori4java.auth.Auth;
import com.github.mjaroslav.shikimori4java.auth.AuthHandler;
import com.github.mjaroslav.shikimori4java.object.AccessToken;
import com.github.mjaroslav.shikimori4java.throwable.login.AuthErrorException;
import com.github.mjaroslav.shikimori4java.throwable.login.LoginErrorException;
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
    public void auth(@NotNull String clientId, @NotNull String clientSecret, @NotNull String redirectUri,
                     @NotNull String appName) throws LoginErrorException {
        if (!Desktop.isDesktopSupported())
            throw new LoginErrorException("Desktop is not supported for this platform");
        try {
            Desktop.getDesktop().browse(Auth.createCodeRequest(clientId, clientSecret, redirectUri).url().toURI());
            val code = String.valueOf(System.console().readLine("Enter code: "));
            val tokenRequest = Auth.createAuthorizationTokenRequest(clientId, clientSecret, redirectUri,
                    code, appName);
            val token = Utils.fromJson(tokenRequest.body(), AccessToken.class);
            if (token.isAuthError())
                throw new AuthErrorException(token);
            setToken(token);
        } catch (Exception e) {
            throw new LoginErrorException(e);
        }
    }
}
