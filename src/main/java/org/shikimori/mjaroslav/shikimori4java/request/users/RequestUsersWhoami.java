package org.shikimori.mjaroslav.shikimori4java.request.users;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectUserFull;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestUsersWhoami extends RequestBase<ObjectUserFull> {
	public RequestUsersWhoami(ShikimoriApp app) {
		super(app, "users/whoami", ObjectUserFull.class);
	}
}
