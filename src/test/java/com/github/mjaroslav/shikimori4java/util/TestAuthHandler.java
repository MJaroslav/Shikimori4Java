package com.github.mjaroslav.shikimori4java.util;

import com.github.mjaroslav.shikimori4java.ShikimoriInfo;
import com.github.mjaroslav.shikimori4java.auth.Auth;
import com.github.mjaroslav.shikimori4java.auth.AuthHandler;
import com.github.mjaroslav.shikimori4java.object.ObjectAccessToken;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestAuthHandler implements AuthHandler {
    @NotNull
    @Getter
    private final String name, clientId, clientSecret, code;

    @Getter
    @Setter
    @UnknownNullability
    private ObjectAccessToken token;

    public TestAuthHandler() throws IOException {
        val credentials = Files.readAllLines(Paths.get("app.credentials"), StandardCharsets.UTF_8);
        name = credentials.get(0);
        clientId = credentials.get(1);
        clientSecret = credentials.get(2);
        code = credentials.get(3);
    }

    @Override
    public boolean auth(@NotNull String clientId, @NotNull String clientSecret, @NotNull String redirectUri, @NotNull String appName) {
        try {
            val tokenRequest = Auth.createAuthorizationTokenRequest(this.clientId, this.clientSecret, ShikimoriInfo.REDIRECT_URI_DEFAULT,
                    code, this.name);
            val token = Utils.fromJson(tokenRequest.body(), ObjectAccessToken.class);
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
        val refreshRequest = Auth.createRefreshTokenRequest(token, this.clientId, this.clientSecret, this.name);
        val refreshedToken = Utils.fromJson(refreshRequest.body(), ObjectAccessToken.class);
        if (refreshedToken != null && !refreshedToken.hasError()) {
            setToken(refreshedToken);
            return true;
        }
        return false;
    }
}
