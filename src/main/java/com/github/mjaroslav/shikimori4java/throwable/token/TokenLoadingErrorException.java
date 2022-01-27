package com.github.mjaroslav.shikimori4java.throwable.token;

import com.github.mjaroslav.shikimori4java.object.Error;
import org.jetbrains.annotations.NotNull;

public class TokenLoadingErrorException extends TokenErrorException{
    public TokenLoadingErrorException() {
        super();
    }

    public TokenLoadingErrorException(@NotNull String message) {
        super(message);
    }

    public TokenLoadingErrorException(@NotNull Error error) {
        super(error);
    }

    public TokenLoadingErrorException(@NotNull String message, @NotNull Throwable cause) {
        super(message, cause);
    }

    public TokenLoadingErrorException(@NotNull Throwable cause) {
        super(cause);
    }
}
