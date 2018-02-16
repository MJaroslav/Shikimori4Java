package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.object.ObjectFranchise;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectFranchise.ObjectNode;

public class Shikimori4Java {
	public static ShikimoriClient client;
	public static ShikimoriApi api = new ShikimoriApi();

	public static void main(String... args) {
		client = ShikimoriApi.loginClient(args[0], args[1]);
		api.setClient(client);
		ObjectFranchise answer = api.mangas().franchise(2).execute();
		for (ObjectNode node : answer.nodes)
			System.out.println(node.id + " " + node.name);
	}
}
