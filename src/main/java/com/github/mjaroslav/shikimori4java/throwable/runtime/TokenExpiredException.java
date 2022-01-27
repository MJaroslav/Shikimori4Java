package com.github.mjaroslav.shikimori4java.throwable.runtime;

import com.github.mjaroslav.shikimori4java.object.Error;
import org.jetbrains.annotations.NotNull;

public class TokenExpiredException extends RuntimeException {
    public TokenExpiredException() {
        super();
    }

    public TokenExpiredException(@NotNull String message) {
        super(message);
    }

    public TokenExpiredException(@NotNull Error error) {
        super(error.errorDesc);
    }

    public TokenExpiredException(@NotNull String message, @NotNull Throwable cause) {
        super(message, cause);
    }

    public TokenExpiredException(@NotNull Throwable cause) {
        super(cause);
    }
}
