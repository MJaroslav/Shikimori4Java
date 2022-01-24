package com.github.mjaroslav.shikimori4java.throwable;

import com.github.mjaroslav.shikimori4java.object.Error;

public class ShikimoriException extends RuntimeException {
    private final String message;
    private final boolean authError;

    public ShikimoriException(String message) {
        super(message);
        this.message = message;
        authError = false;
    }

    public ShikimoriException(String message, boolean isAuthError) {
        super(message);
        this.message = message;
        authError = isAuthError;
    }

    public ShikimoriException(Error error) {
        super(error.toString());
        this.message = error.toString();
        authError = error.isAuthError();
    }

    public ShikimoriException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        authError = false;
    }

    public String getErrorMessage() {
        return message;
    }

    public boolean isAuthError() {
        return authError;
    }
}
