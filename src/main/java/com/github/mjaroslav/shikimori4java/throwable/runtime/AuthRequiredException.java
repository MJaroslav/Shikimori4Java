package com.github.mjaroslav.shikimori4java.throwable.runtime;

import com.github.mjaroslav.shikimori4java.object.Error;
import org.jetbrains.annotations.NotNull;

public class AuthRequiredException extends RequestErrorException {
    public AuthRequiredException() {
        super();
    }

    public AuthRequiredException(@NotNull Error error) {
        super(error);
    }

    public AuthRequiredException(String message) {
        super(message);
    }

    public AuthRequiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthRequiredException(Throwable cause) {
        super(cause);
    }

    protected AuthRequiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
