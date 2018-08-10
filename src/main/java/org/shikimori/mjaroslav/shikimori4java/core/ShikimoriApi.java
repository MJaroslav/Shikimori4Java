package org.shikimori.mjaroslav.shikimori4java.core;

import org.shikimori.mjaroslav.shikimori4java.api.ApiAnimes;
import org.shikimori.mjaroslav.shikimori4java.api.ApiMangas;

public class ShikimoriApi {
	public static final String siteUrl = "https://shikimori.org";
	public static final String apiUrl = siteUrl + "/api";

	private ShikimoriClient client;



	public ShikimoriApi(ShikimoriClient client) {
		this.client = client;
	}

	public ShikimoriApi() {
	}

	public void setClient(ShikimoriClient client) {
		this.client = client;
	}

	public ShikimoriClient getClient() {
		return client;
	}

}
