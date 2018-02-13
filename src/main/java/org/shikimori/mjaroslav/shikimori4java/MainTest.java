package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimes;
import org.shikimori.mjaroslav.shikimori4java.responce.ResponceAnime;

public class MainTest {
	public static ShikimoriClient client;

	public static void main(String... args) {
		client = ShikimoriApi.loginClient(args[0], args[1]);
		ResponceAnime[] responce = new RequestAnimes(client).setMylist("completed").setLimit(50).getResponce();
		for (ResponceAnime anime : responce)
			System.out.println(anime.status + " " + anime.kind + " " + anime.russian + " " + anime.url);
	}
}
