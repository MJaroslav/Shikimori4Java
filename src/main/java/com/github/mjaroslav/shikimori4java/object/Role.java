package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;
import lombok.ToString;

import java.util.List;

@ToString
public class Role {
    public List<String> roles;
    @SerializedName("roles_russian")
    public List<String> rolesRussian;
    public PersonCharacter character;
    public PersonCharacter person;
}
