package com.github.mjaroslav.shikimori4java;

import com.github.mjaroslav.shikimori4java.auth.AuthHandler;
import com.github.mjaroslav.shikimori4java.object.AccessToken;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

public class DummyAuthHandler implements AuthHandler {
    @UnknownNullability
    @Getter
    @Setter
    private AccessToken token;

    @Override
    public void auth(@NotNull String clientId, @NotNull String clientSecret, @NotNull String redirectUri,
                     @NotNull String appName) {
    }
}
