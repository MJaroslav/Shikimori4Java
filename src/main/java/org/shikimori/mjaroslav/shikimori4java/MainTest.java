package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.object.ObjectFranchise;
import org.shikimori.mjaroslav.shikimori4java.request.RequestAnimesFranchise;

public class MainTest {
	public static ShikimoriClient client;

	public static void main(String... args) {
		client = ShikimoriApi.loginClient(args[0], args[1]);
		ObjectFranchise answer = new RequestAnimesFranchise(20785).getResponce();
		for (ObjectFranchise.ObjectLink link : answer.links)
			System.out.println(link.relation + " " + link.source + " " + link.target + " " + link.weight);
		for (ObjectFranchise.ObjectNode node : answer.nodes)
			System.out.println(node.id + " " + node.name + " " + node.kind + " " + node.weight + " " + node.url);
	}
}
