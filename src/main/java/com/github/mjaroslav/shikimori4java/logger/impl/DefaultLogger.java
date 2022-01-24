package com.github.mjaroslav.shikimori4java.logger.impl;

import com.github.mjaroslav.shikimori4java.logger.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultLogger implements Logger {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("y-MM-dd HH:mm:ss.SSS");

    @Override
    public void info(@Nullable String message, @NotNull Object... args) {
        log("INFO", message, null, args);
    }

    @Override
    public void info(@Nullable String message, @NotNull Throwable t, @NotNull Object... args) {
        log("INFO", message, t, args);
    }

    @Override
    public void error(@Nullable String message, @NotNull Object... args) {
        log("ERROR", message, null, args);
    }

    @Override
    public void error(@Nullable String message, @NotNull Throwable t, @NotNull Object... args) {
        log("ERROR", message, t, args);
    }

    @Override
    public void warn(@Nullable String message, @NotNull Object... args) {
        log("WARNING", message, null, args);
    }

    @Override
    public void warn(@Nullable String message, @NotNull Throwable t, @NotNull Object... args) {
        log("WARNING", message, t, args);
    }

    @Override
    public void debug(@Nullable String message, @NotNull Object... args) {
        log("DEBUG", message, null, args);
    }

    @Override
    public void debug(@Nullable String message, @NotNull Throwable t, @NotNull Object... args) {
        log("DEBUG", message, t, args);
    }

    private static void log(@NotNull String level, @Nullable String message, @Nullable Throwable t,
                            @NotNull Object... args) {
        if (message == null)
            message = "";
        message = String.format(message, args);
        System.out.printf("%s %s [%s] -  %s%n", FORMAT.format(new Date()), level, Thread.currentThread().getName(),
                message);
        if (t != null)
            t.printStackTrace();
    }
}
