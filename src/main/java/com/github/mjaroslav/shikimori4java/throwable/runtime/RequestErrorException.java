package com.github.mjaroslav.shikimori4java.throwable.runtime;

import com.github.mjaroslav.shikimori4java.object.Error;
import org.jetbrains.annotations.NotNull;

public class RequestErrorException extends RuntimeException {
    public RequestErrorException() {
        super();
    }

    public RequestErrorException(@NotNull Error error) {
        super(error.errorDesc);
    }

    public RequestErrorException(String message) {
        super(message);
    }


    public RequestErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestErrorException(Throwable cause) {
        super(cause);
    }

    protected RequestErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
