package org.shikimori.mjaroslav.shikimori4java.object;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ObjectUserFull extends ObjectUser {
	@SerializedName("name")
	public String name;

	@SerializedName("sex")
	public String sex;

	@SerializedName("full_years")
	public int fullYears;

	@SerializedName("last_online")
	public String lastOnline;

	@SerializedName("website")
	public String website;

	@SerializedName("location")
	public String location;

	@SerializedName("banned")
	public boolean banned;

	@SerializedName("about")
	public String about;

	@SerializedName("about_html")
	public String aboutHtml;

	@SerializedName("common_info")
	public List<String> commonInfo;

	@SerializedName("show_comments")
	public boolean showComments;

	@SerializedName("in_frends")
	public List<ObjectUser> inFrends;

	@SerializedName("is_ignored")
	public boolean isIgnored;
}
