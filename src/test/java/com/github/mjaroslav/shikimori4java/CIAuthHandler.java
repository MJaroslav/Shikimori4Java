package com.github.mjaroslav.shikimori4java;

import com.github.mjaroslav.shikimori4java.auth.Auth;
import com.github.mjaroslav.shikimori4java.auth.AuthHandler;
import com.github.mjaroslav.shikimori4java.object.AccessToken;
import com.github.mjaroslav.shikimori4java.util.Utils;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

public class CIAuthHandler implements AuthHandler {
    @UnknownNullability
    @Getter
    @Setter
    private AccessToken token;

    @Override
    public void auth(@NotNull String clientId, @NotNull String clientSecret, @NotNull String redirectUri,
                     @NotNull String appName) {
        val code = System.getenv("CODE_PASSWORD");
        val request = Auth.createAuthorizationTokenRequest(clientId, clientSecret, redirectUri, code, appName);
        val result = Utils.fromJson(request.body(), AccessToken.class);
        setToken(result);
    }
}
