package com.github.mjaroslav.shikimori4java.auth;

import com.github.mjaroslav.shikimori4java.object.AccessToken;
import com.github.mjaroslav.shikimori4java.throwable.token.TokenLoadingErrorException;
import com.github.mjaroslav.shikimori4java.throwable.token.TokenSavingErrorException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TokenStorage {
    @Nullable
    AccessToken loadToken() throws TokenLoadingErrorException;

    void saveToken(@NotNull AccessToken token) throws TokenSavingErrorException;
}
