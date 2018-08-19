package org.shikimori.mjaroslav.shikimori4java.utils;

import org.shikimori.mjaroslav.shikimori4java.object.ObjectError;

public class ShikimoriException extends RuntimeException {
    private static final long serialVersionUID = 1L;

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

    public ShikimoriException(ObjectError error) {
        super(error.toString());
        this.message = error.toString();
        authError = !error.isNotAuthError();
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
