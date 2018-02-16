package org.shikimori.mjaroslav.shikimori4java.api;

import org.shikimori.mjaroslav.shikimori4java.ShikimoriApi;
import org.shikimori.mjaroslav.shikimori4java.ShikimoriClient;

public class ApiBase {
	private ShikimoriApi api;

	public ApiBase(ShikimoriApi api) {
		this.api = api;
	}

	public ShikimoriApi getApi() {
		return api;
	}

	public ShikimoriClient getClient() {
		return getApi().getClient();
	}
}
