package org.shikimori.mjaroslav.shikimori4java.object;

import java.util.List;

import com.google.gson.annotations.SerializedName;

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
