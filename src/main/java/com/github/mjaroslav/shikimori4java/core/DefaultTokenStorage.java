package com.github.mjaroslav.shikimori4java.core;

import java.io.File;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import com.github.mjaroslav.shikimori4java.object.ObjectAccessToken;

import com.google.gson.Gson;

public class DefaultTokenStorage implements ITokenStorage {
    private static final Gson gson = new Gson();

    @Override
    public void saveToken(String appName, String nickname, ObjectAccessToken token) throws Exception {
        if (token.isNotAuthError())
            if ((getFolder().exists() && getFolder().isDirectory()) || getFolder().mkdirs()) {
                File dir = getFolder().toPath().resolve(appName).toFile();
                if ((dir.exists() && dir.isDirectory()) || dir.mkdirs()) {
                    File tokenFile = dir.toPath().resolve(nickname + ".json").toFile();
                    if ((tokenFile.exists() && tokenFile.isFile()) || tokenFile.createNewFile()) {
                        Writer writer = Files.newBufferedWriter(tokenFile.toPath(), StandardCharsets.UTF_8);
                        gson.toJson(token, writer);
                        writer.close();
                    }
                }
            }
    }

    @Override
    public ObjectAccessToken loadToken(String appName, String nickname) throws Exception {
        if (getFolder().exists() && getFolder().isDirectory()) {
            File dir = getFolder().toPath().resolve(appName).toFile();
            if (dir.exists() && dir.isDirectory()) {
                File tokenFile = dir.toPath().resolve(nickname + ".json").toFile();
                if (tokenFile.exists() && tokenFile.isFile()) {
                    Reader reader = Files.newBufferedReader(tokenFile.toPath(), StandardCharsets.UTF_8);
                    ObjectAccessToken token = gson.fromJson(reader, ObjectAccessToken.class);
                    reader.close();
                    return token;
                }
            }
        }
        return null;
    }

    @Override
    public File getFolder() {
        return new File(System.getProperty("user.home") + "/.mjapies/shikimori4java");
    }
}
