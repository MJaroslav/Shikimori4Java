package com.github.mjaroslav.shikimori4java.throwable.login;

import com.github.mjaroslav.shikimori4java.object.Error;
import org.jetbrains.annotations.NotNull;

public class AuthErrorException extends LoginErrorException {
    public AuthErrorException() {
        super();
    }

    public AuthErrorException(@NotNull Throwable cause) {
        super(cause);
    }

    public AuthErrorException(@NotNull String message) {
        super(message);
    }

    public AuthErrorException(@NotNull Error error) {
        super(error);
    }

    public AuthErrorException(@NotNull String message, @NotNull Throwable cause) {
        super(message, cause);
    }
}
