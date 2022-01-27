package com.github.mjaroslav.shikimori4java.throwable;

import com.github.mjaroslav.shikimori4java.object.Error;
import org.jetbrains.annotations.NotNull;

public class ShikimoriException extends Exception {
    public ShikimoriException() {
        super();
    }

    public ShikimoriException(@NotNull Error error) {
        super(error.errorDesc);
    }

    public ShikimoriException(@NotNull String message) {
        super(message);
    }

    public ShikimoriException(@NotNull String message, @NotNull Throwable cause) {
        super(message, cause);
    }

    public ShikimoriException(@NotNull Throwable cause) {
        super(cause);
    }
}
