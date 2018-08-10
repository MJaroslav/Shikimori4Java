package org.shikimori.mjaroslav.shikimori4java.core;

import org.shikimori.mjaroslav.shikimori4java.utils.Utils;

public class ShikimoriClient {
	private String token;
	private boolean logged;
	private final ShikimoriApp app;
	private String username;

	public ShikimoriClient(ShikimoriApp app) {
		token = "";
		logged = false;
		this.app = app;
	}

	public ShikimoriClient(ShikimoriApp app, String token) {
		this.token = token;
		this.logged = true;
		this.app = app;
	}

	public String getToken() {
		return token;
	}

	public boolean isLogged() {
		return logged;
	}

	public String getUserAgent() {
		return app.getUserAgent();
	}

	public String getAuthorization() {
		return "Bearer " + getToken();
	}
	
	public String getUsername() {
		if(Utils.stringNotEmpty(username))
			username = getApp().getUsername();
		return username;
	}
	
	public ShikimoriApp getApp() {
		return app;
	}
}
