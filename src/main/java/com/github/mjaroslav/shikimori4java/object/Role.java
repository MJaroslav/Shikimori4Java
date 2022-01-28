package com.github.mjaroslav.shikimori4java.object;

import com.google.gson.annotations.SerializedName;
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
