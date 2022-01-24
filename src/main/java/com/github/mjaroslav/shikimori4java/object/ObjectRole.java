package com.github.mjaroslav.shikimori4java.object;

import blue.endless.jankson.annotation.SerializedName;

import java.util.List;

public class ObjectRole {
    @SerializedName("roles")
    public List<String> roles;
    @SerializedName("roles_russian")
    public List<String> rolesRussian;
    @SerializedName("character")
    public ObjectPersonCharacter character;
    @SerializedName("person")
    public ObjectPersonCharacter person;
}
