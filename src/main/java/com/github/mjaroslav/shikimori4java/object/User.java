package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;
import lombok.ToString;

@ToString(callSuper = true)
public class User extends UserMinimal {
    public String name;
    public String sex;
    public String website;
    @SerializedName("birth_on")
    public String birthOn;
    public String locale;
}
