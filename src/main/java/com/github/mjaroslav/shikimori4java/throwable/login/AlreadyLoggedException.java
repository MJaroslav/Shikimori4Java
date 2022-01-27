package com.github.mjaroslav.shikimori4java.throwable.login;

import com.github.mjaroslav.shikimori4java.object.Error;
import org.jetbrains.annotations.NotNull;

public class AlreadyLoggedException extends LoginErrorException {
    public AlreadyLoggedException() {
        super();
    }

    public AlreadyLoggedException(@NotNull Throwable cause) {
        super(cause);
    }

    public AlreadyLoggedException(@NotNull String message) {
        super(message);
    }

    public AlreadyLoggedException(@NotNull Error error) {
        super(error);
    }

    public AlreadyLoggedException(@NotNull String message, @NotNull Throwable cause) {
        super(message, cause);
    }
}
