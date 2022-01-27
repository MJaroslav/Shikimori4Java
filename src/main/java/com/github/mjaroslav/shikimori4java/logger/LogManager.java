package com.github.mjaroslav.shikimori4java.logger;

import com.github.mjaroslav.shikimori4java.logger.impl.DefaultLogger;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@UtilityClass
public class LogManager {
    private Logger logger;

    @NotNull
    public Logger getLogger() {
        if (logger == null)
            logger = new DefaultLogger();
        return logger;
    }

    public void setLogger(@Nullable Logger logger) {
        LogManager.logger = logger;
    }
}
