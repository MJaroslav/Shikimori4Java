package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;
import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriClient;

public class Shikimori4Java {
	public static void main(String... args) throws Exception {
		ShikimoriApp app = new ShikimoriApp(args[0], args[1], args[2]);
		ShikimoriClient client = app.auth();
		System.out.println(client.getUsername());
	}
}
