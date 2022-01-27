package com.github.mjaroslav.shikimori4java.throwable.token;

import com.github.mjaroslav.shikimori4java.object.Error;
import com.github.mjaroslav.shikimori4java.throwable.ShikimoriException;
import com.github.mjaroslav.shikimori4java.throwable.login.LoginErrorException;
import org.jetbrains.annotations.NotNull;

public class TokenErrorException extends ShikimoriException {
    public TokenErrorException() {
        super();
    }

    public TokenErrorException(@NotNull String message) {
        super(message);
    }

    public TokenErrorException(@NotNull Error error) {
        super(error);
    }

    public TokenErrorException(@NotNull String message, @NotNull Throwable cause) {
        super(message, cause);
    }

    public TokenErrorException(@NotNull Throwable cause) {
        super(cause);
    }
}
