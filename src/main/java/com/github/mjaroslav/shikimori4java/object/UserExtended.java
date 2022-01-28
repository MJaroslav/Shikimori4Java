package com.github.mjaroslav.shikimori4java.object;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

import java.util.List;

@ToString(callSuper = true)
public class UserExtended extends User {
    @SerializedName("full_years")
    public int fullYears;
    @SerializedName("last_online")
    public String lastOnline;
    public String location;
    public boolean banned;
    public String about;
    @SerializedName("about_html")
    public String aboutHtml;
    @SerializedName("common_info")
    public List<String> commonInfo;
    @SerializedName("show_comments")
    public boolean showComments;
    @SerializedName("in_friends")
    public boolean inFriends;
    @SerializedName("is_ignored")
    public boolean isIgnored;
}
