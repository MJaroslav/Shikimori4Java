package com.github.mjaroslav.shikimori4java.auth;

import com.github.mjaroslav.shikimori4java.object.ObjectAccessToken;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TokenStorage {
    @Nullable
    ObjectAccessToken loadToken() throws Exception;

    void saveToken(@NotNull ObjectAccessToken token) throws Exception;
}
