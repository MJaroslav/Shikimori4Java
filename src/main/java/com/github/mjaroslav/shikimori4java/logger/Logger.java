package com.github.mjaroslav.shikimori4java.logger;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Logger {
    void info(@Nullable Object message, @NotNull Object... args);

    void info(@Nullable Object message, @NotNull Throwable t, @NotNull Object... args);

    void error(@Nullable Object message, @NotNull Object... args);

    void error(@Nullable Object message, @NotNull Throwable t, @NotNull Object... args);

    void warn(@Nullable Object message, @NotNull Object... args);

    void warn(@Nullable Object message, @NotNull Throwable t, @NotNull Object... args);

    void debug(@Nullable Object message, @NotNull Object... args);

    void debug(@Nullable Object message, @NotNull Throwable t, @NotNull Object... args);
}
