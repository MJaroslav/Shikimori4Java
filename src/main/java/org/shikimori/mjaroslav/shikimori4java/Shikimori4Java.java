package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.object.EnumAnimeKind;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectAnime;

public class Shikimori4Java {
	public static void main(String... args) {
		ShikimoriApp app = new ShikimoriApp(args[0], args[1], args[2]);
		try {
			app.auth("MJaroslav", true);
			for (ObjectAnime anime : app.animes().search("Steins;Gate", 4).setKind(EnumAnimeKind.NOTMOVIE).execute())
				System.out.println(anime.name + " " + anime.status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
