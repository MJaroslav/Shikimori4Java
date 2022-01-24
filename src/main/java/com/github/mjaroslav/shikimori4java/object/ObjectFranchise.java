package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;

import java.util.List;

public class ObjectFranchise {
    @SerializedName("links")
    public List<ObjectLink> links;
    @SerializedName("nodes")
    public List<ObjectNode> nodes;

    public static class ObjectLink {
        @SerializedName("source")
        public String source;
        @SerializedName("target")
        public int target;
        @SerializedName("weight")
        public int weight;
        @SerializedName("relation")
        public String relation;
    }

    public static class ObjectNode {
        @SerializedName("id")
        public int id;
        @SerializedName("date")
        public long date;
        @SerializedName("name")
        public String name;
        @SerializedName("image_url")
        public String imageUrl;
        @SerializedName("url")
        public String url;
        @SerializedName("year")
        public String year;
        @SerializedName("kind")
        public String kind;
        @SerializedName("weight")
        public int weight;
    }
}
