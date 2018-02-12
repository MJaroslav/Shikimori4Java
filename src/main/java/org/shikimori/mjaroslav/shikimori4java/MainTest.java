package org.shikimori.mjaroslav.shikimori4java;

public class MainTest {
	public static void main(String... args) {
		ShikimoriClient client = new ShikimoriClient(args[0], args[1]);
		System.out.println(client.getToken());
	}
}
