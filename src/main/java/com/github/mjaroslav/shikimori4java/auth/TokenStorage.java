package com.github.mjaroslav.shikimori4java.auth;

import com.github.mjaroslav.shikimori4java.object.AccessToken;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TokenStorage {
    @Nullable
    AccessToken loadToken() throws Exception;

    void saveToken(@NotNull AccessToken token) throws Exception;
}
