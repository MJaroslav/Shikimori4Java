package org.shikimori.mjaroslav.shikimori4java.core;

import java.io.File;

import org.shikimori.mjaroslav.shikimori4java.object.ObjectAccessToken;

public interface ITokenStorage {
	public void saveToken(String appName, String nickname, ObjectAccessToken token) throws Exception;

	public ObjectAccessToken loadToken(String appName, String nickname) throws Exception;

	public File getFolder();
}
