package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.object.ObjectAnime;
import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimesSimilar;

public class MainTest {
	public static ShikimoriClient client;

	public static void main(String... args) {
		client = ShikimoriApi.loginClient(args[0], args[1]);
		ObjectAnime[] answer = new RequestAnimesSimilar(20785).getResponce();
		for (ObjectAnime anime : answer)
			System.out.println(anime.nameRussian);
	}
}
