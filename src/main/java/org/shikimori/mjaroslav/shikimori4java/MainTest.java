package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.object.ObjectRole;
import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimesRoles;

public class MainTest {
	public static ShikimoriClient client;

	public static void main(String... args) {
		client = ShikimoriApi.loginClient(args[0], args[1]);
		ObjectRole[] answer = new RequestAnimesRoles(20785).getResponce();
		for (ObjectRole role : answer)
			System.out.println(role.rolesRussian.get(0) + " "
					+ (role.character != null ? role.character.nameRussian : role.person.nameRussian));
	}
}
