package com.github.mjaroslav.shikimori4java.auth.impl;

import com.github.mjaroslav.shikimori4java.auth.TokenStorage;
import com.github.mjaroslav.shikimori4java.object.AccessToken;
import com.github.mjaroslav.shikimori4java.util.Utils;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public final class DefaultTokenStorage implements TokenStorage {
    @Getter
    @Setter
    private Path tokenPath = Paths.get("token.json");

    @Override
    public @Nullable AccessToken loadToken() throws Exception {
        return Utils.fromJson(Utils.readFileText(tokenPath), AccessToken.class);
    }

    @Override
    public void saveToken(@NotNull AccessToken token) throws Exception {
        Files.write(tokenPath, Collections.singleton(Utils.toJson(token)), StandardCharsets.UTF_8);
    }
}
