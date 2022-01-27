package com.github.mjaroslav.shikimori4java.throwable.token;

import com.github.mjaroslav.shikimori4java.object.Error;
import org.jetbrains.annotations.NotNull;

public class TokenSavingErrorException extends TokenErrorException {
    public TokenSavingErrorException() {
        super();
    }

    public TokenSavingErrorException(@NotNull String message) {
        super(message);
    }

    public TokenSavingErrorException(@NotNull Error error) {
        super(error);
    }

    public TokenSavingErrorException(@NotNull String message, @NotNull Throwable cause) {
        super(message, cause);
    }

    public TokenSavingErrorException(@NotNull Throwable cause) {
        super(cause);
    }
}
