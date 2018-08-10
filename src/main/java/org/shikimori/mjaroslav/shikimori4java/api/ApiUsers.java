package org.shikimori.mjaroslav.shikimori4java.api;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.request.users.RequestUsersWhoami;

public class ApiUsers extends ApiBase {
	public ApiUsers(ShikimoriApp app) {
		super(app);
	}

	public RequestUsersWhoami whoami() {
		return new RequestUsersWhoami(getClient());
	}
}
