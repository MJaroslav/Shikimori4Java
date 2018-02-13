package org.shikimori.mjaroslav.shikimori4java.object;

import com.google.gson.annotations.SerializedName;

public class ObjectExternalLink {
	@SerializedName("id")
	public int id;
	@SerializedName("kind")
	public String kind;
	@SerializedName("url")
	public String url;
	@SerializedName("source")
	public String source;
	@SerializedName("entry_id")
	public int entryId;
	@SerializedName("entry_type")
	public String entryType;
	@SerializedName("created_at")
	public String createdAt;
	@SerializedName("updated_at")
	public String updatedAt;
	@SerializedName("imported_at")
	public String importedAt;
}
