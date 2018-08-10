package org.shikimori.mjaroslav.shikimori4java.core;

public class DefaultAppLogger implements IAppLogger {
	@Override
	public void info(String message) {
		System.out.println("[INFO] " + message);
	}

	@Override
	public void error(String message) {
		System.out.println("[ERROR] " + message);
	}

	@Override
	public void error(String message, Throwable t) {
		System.out.println("[ERROR] " + message);
		t.printStackTrace();
	}

	@Override
	public void warn(String message) {
		System.out.println("[WARN] " + message);
	}

	@Override
	public void debug(String message) {
		System.out.println("[DEBUG] " + message);
	}
}
