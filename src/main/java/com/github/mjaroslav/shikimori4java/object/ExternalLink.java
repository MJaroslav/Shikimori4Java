package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;
import lombok.ToString;

@ToString
public class ExternalLink {
    public int id;
    public String kind;
    public String url;
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
