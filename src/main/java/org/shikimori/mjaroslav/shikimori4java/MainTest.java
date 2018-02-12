package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimes;
import org.shikimori.mjaroslav.shikimori4java.responce.ResponceAnime;

public class MainTest {
	public static void main(String... args) {
		ResponceAnime[] responce = new RequestAnimes().setLimit(30).getResponce();
		for (ResponceAnime anime : responce)
			System.out.println(anime.status + " " + anime.kind + " " + anime.russian + " " + anime.url);
	}
}
