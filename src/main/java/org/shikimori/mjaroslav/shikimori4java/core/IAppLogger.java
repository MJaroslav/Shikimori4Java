package org.shikimori.mjaroslav.shikimori4java.core;

public interface IAppLogger {
	public void info(String message);

	public void error(String message);

	public void error(String message, Throwable t);

	public void warn(String message);

	public void debug(String message);
}
