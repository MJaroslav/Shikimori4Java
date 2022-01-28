package com.github.mjaroslav.shikimori4java.object;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

import java.util.List;

@ToString
public class Franchise {
    public List<Link> links;
    public List<Node> nodes;

    @ToString
    public static class Link {
        public String source;
        public int target;
        public int weight;
        public String relation;
    }

    @ToString
    public static class Node {
        public int id;
        public long date;
        public String name;
        @SerializedName("image_url")
        public String imageUrl;
        @SerializedName("url")
        public String url;
        public String year;
        public String kind;
        public int weight;
    }
}
