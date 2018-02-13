package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.object.EnumAnimeOrder;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectAnime;

public class MainTest {
	public static ShikimoriClient client;
	public static ShikimoriApi api = new ShikimoriApi();

	public static void main(String... args) {
		client = ShikimoriApi.loginClient(args[0], args[1]);
		api.setClient(client);
		ObjectAnime[] answer = api.anime().list().setSearch("Fate").setLimit(50).setCensored(false)
				.setOrder(EnumAnimeOrder.POPULARITY).getResponce();
		for (ObjectAnime anime : answer)
			System.out.println(anime.id + " " + anime.name);
	}
}
