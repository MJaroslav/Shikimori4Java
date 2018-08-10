package org.shikimori.mjaroslav.shikimori4java.api;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;

public class ApiBase {
	private ShikimoriApp app;

	public ApiBase(ShikimoriApp app) {
		this.app = app;
	}

	public ShikimoriApp getApp() {
		return app;
	}

	public ShikimoriClient getClient() {
		return getApp().getClient();
	}
}
