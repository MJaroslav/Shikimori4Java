package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.object.EnumType;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectManga;

public class Shikimori4Java {
	public static ShikimoriClient client;
	public static ShikimoriApi api = new ShikimoriApi();

	public static void main(String... args) {
		client = ShikimoriApi.loginClient(args[0], args[1]);
		api.setClient(client);
		ObjectManga[] answer = api.mangas().pattern().setMylist(EnumType.PLANNED).setLimit(50).execute();
		for (ObjectManga node : answer)
			System.out.println(node.id + " " + node.name);
	}
}
