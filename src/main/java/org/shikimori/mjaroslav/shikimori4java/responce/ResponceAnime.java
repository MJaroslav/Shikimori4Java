package org.shikimori.mjaroslav.shikimori4java.responce;

public class ResponceAnime {
	public int id;
	public String name;
	public String russian;
	public Image image;

	public static class Image {
		public String original;
		public String preview;
		public String x96;
		public String x48;
	}

	public String url;
	public String kind;
	public String status;
	public int episodes;
	public int episodes_aired;
	public String aired_on;
	public String released_on;
}
