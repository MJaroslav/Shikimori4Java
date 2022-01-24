package com.github.mjaroslav.shikimori4java.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Logger {
    void info(@Nullable String message, @NotNull Object... args);

    void info(@Nullable String message, @NotNull Throwable t, @NotNull Object... args);

    void error(@Nullable String message, @NotNull Object... args);

    void error(@Nullable String message, @NotNull Throwable t, @NotNull Object... args);

    void warn(@Nullable String message, @NotNull Object... args);

    void warn(@Nullable String message, @NotNull Throwable t, @NotNull Object... args);

    void debug(@Nullable String message, @NotNull Object... args);

    void debug(@Nullable String message, @NotNull Throwable t, @NotNull Object... args);
}
