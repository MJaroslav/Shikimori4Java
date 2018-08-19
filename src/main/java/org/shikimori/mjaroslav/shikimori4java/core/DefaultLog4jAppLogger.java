package org.shikimori.mjaroslav.shikimori4java.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultLog4jAppLogger implements IAppLogger {
    private final Logger logger;

    public DefaultLog4jAppLogger(ShikimoriApp app) {
        logger = LogManager.getLogger(app.getAppName());
    }

    public DefaultLog4jAppLogger(String name) {
        logger = LogManager.getLogger(name);
    }

    public DefaultLog4jAppLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(String message, Throwable t) {
        logger.error(message, t);
    }

    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    public Logger getLogger() {
        return logger;
    }
}
