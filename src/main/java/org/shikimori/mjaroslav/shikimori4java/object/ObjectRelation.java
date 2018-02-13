package org.shikimori.mjaroslav.shikimori4java.object;

import com.google.gson.annotations.SerializedName;

public class ObjectRelation {
	@SerializedName("relation")
	public String relation;
	@SerializedName("relation_russian")
	public String relationRussian;
	@SerializedName("anime")
	public ObjectAnime anime;
}
