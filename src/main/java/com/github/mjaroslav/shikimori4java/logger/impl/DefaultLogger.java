package com.github.mjaroslav.shikimori4java.logger.impl;

import com.github.mjaroslav.shikimori4java.logger.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultLogger implements Logger {
    private static final Level LEVEL = Level.valueOf(System.getProperty("s4j.logger.level", "INFO").toUpperCase());

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("y-MM-dd HH:mm:ss.SSS");

    @Override
    public void info(@Nullable Object message, @NotNull Object... args) {
        log(Level.INFO, message, null, args);
    }

    @Override
    public void info(@Nullable Object message, @NotNull Throwable t, @NotNull Object... args) {
        log(Level.INFO, message, t, args);
    }

    @Override
    public void error(@Nullable Object message, @NotNull Object... args) {
        log(Level.ERROR, message, null, args);
    }

    @Override
    public void error(@Nullable Object message, @NotNull Throwable t, @NotNull Object... args) {
        log(Level.ERROR, message, t, args);
    }

    @Override
    public void warn(@Nullable Object message, @NotNull Object... args) {
        log(Level.WARN, message, null, args);
    }

    @Override
    public void warn(@Nullable Object message, @NotNull Throwable t, @NotNull Object... args) {
        log(Level.WARN, message, t, args);
    }

    @Override
    public void debug(@Nullable Object message, @NotNull Object... args) {
        log(Level.DEBUG, message, null, args);
    }

    @Override
    public void debug(@Nullable Object message, @NotNull Throwable t, @NotNull Object... args) {
        log(Level.DEBUG, message, t, args);
    }

    private static void log(@NotNull Level level, @Nullable Object message, @Nullable Throwable t,
                            @NotNull Object... args) {
        if (level.ordinal() < LEVEL.ordinal())
            return;
        if (message == null)
            message = "";
        message = String.format(message.toString(), args);
        System.out.printf("%s [S4J] %s [%s] - %s%n", FORMAT.format(new Date()), level, Thread.currentThread().getName(),
                message);
        if (t != null)
            t.printStackTrace();
    }

    private enum Level {
        DEBUG, INFO, WARN, ERROR
    }
}
