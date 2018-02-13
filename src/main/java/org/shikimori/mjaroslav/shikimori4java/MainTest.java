package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.object.ObjectImage;
import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimeScreenshots;

public class MainTest {
	public static ShikimoriClient client;

	public static void main(String... args) {
		client = ShikimoriApi.loginClient(args[0], args[1]);
		ObjectImage[] answer = new RequestAnimeScreenshots(20785).getResponce();
		for (ObjectImage image : answer)
			System.out.println(image.getOriginalFull());
	}
}
