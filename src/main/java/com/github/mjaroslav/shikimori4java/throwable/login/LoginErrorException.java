package com.github.mjaroslav.shikimori4java.throwable.login;

import com.github.mjaroslav.shikimori4java.object.Error;
import com.github.mjaroslav.shikimori4java.throwable.ShikimoriException;
import org.jetbrains.annotations.NotNull;

public class LoginErrorException extends ShikimoriException {
    public LoginErrorException() {
        super();
    }

    public LoginErrorException(@NotNull Throwable cause) {
        super(cause);
    }

    public LoginErrorException(@NotNull String message) {
        super(message);
    }

    public LoginErrorException(@NotNull Error error) {
        super(error);
    }

    public LoginErrorException(@NotNull String message, @NotNull Throwable cause) {
        super(message, cause);
    }
}
