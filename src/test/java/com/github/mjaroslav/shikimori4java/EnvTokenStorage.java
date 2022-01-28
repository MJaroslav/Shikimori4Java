package com.github.mjaroslav.shikimori4java;

import com.github.mjaroslav.shikimori4java.auth.TokenStorage;
import com.github.mjaroslav.shikimori4java.object.AccessToken;
import com.github.mjaroslav.shikimori4java.throwable.token.TokenSavingErrorException;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EnvTokenStorage implements TokenStorage {
    @Override
    public @Nullable AccessToken loadToken() {
        val token = System.getenv("TOKEN_PASSWORD");
        val refreshToken = System.getenv("TOKEN_REFRESH_PASSWORD");
        val result = new AccessToken();
        result.accessToken = token;
        result.refreshToken = refreshToken;
        result.createdAt = Long.parseLong(System.getenv("TOKEN_CREATED_AT"));
        result.expiresIn = Long.parseLong(System.getenv("TOKEN_EXPIRES_IN"));
        return result;
    }

    @Override
    public void saveToken(@NotNull AccessToken token) throws TokenSavingErrorException {
        try {
            val os = System.getProperty("os.name");
            val prefix = os.toLowerCase().startsWith("windows") ? "set" : "export";
            Runtime.getRuntime().exec(String.format("%s TOKEN_PASSWORD=%s", prefix, token.accessToken));
            Runtime.getRuntime().exec(String.format("%s TOKEN_REFRESH_PASSWORD=%s", prefix, token.refreshToken));
            Runtime.getRuntime().exec(String.format("%s TOKEN_CREATED_AT=%s", prefix, token.createdAt));
            Runtime.getRuntime().exec(String.format("%s TOKEN_EXPIRES_IN=%s", prefix, token.expiresIn));
        } catch (Exception e) {
            throw new TokenSavingErrorException(e);
        }
    }
}
