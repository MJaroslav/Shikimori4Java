package com.github.mjaroslav.shikimori4java.object;

import com.google.gson.annotations.SerializedName;

public class ObjectUserMe extends ObjectUser {
    @SerializedName("name")
    public String name;

    @SerializedName("sex")
    public String sex;

    @SerializedName("website")
    public String website;

    @SerializedName("birth_on")
    public String birthOn;

    @SerializedName("locale")
    public String locale;
}
