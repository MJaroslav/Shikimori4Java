package org.shikimori.mjaroslav.shikimori4java.request.users;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectUserFull;
import org.shikimori.mjaroslav.shikimori4java.request.RequestBase;

public class RequestUsersWhoami extends RequestBase<ObjectUserFull> {
	public RequestUsersWhoami(ShikimoriClient client) {
		super(client, "users/whoami", ObjectUserFull.class);
	}
}
