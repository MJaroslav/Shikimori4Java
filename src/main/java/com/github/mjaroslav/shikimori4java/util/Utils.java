package com.github.mjaroslav.shikimori4java.util;


import com.github.mjaroslav.shikimori4java.logger.LogManager;
import com.github.mjaroslav.shikimori4java.object.Image;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@UtilityClass
public class Utils {
    public final Gson GSON = new GsonBuilder().registerTypeAdapter(Image.class, new ImageDeserializer()).create();

    @Contract("null -> false")
    public boolean stringNotEmpty(@Nullable String str) {
        return str != null && str.length() > 0 && !str.equals("null");
    }

    @NotNull
    public String readFileText(@NotNull Path path) throws IOException {
        return String.join("\n", Files.readAllLines(path, StandardCharsets.UTF_8));
    }

    @UnknownNullability
    public <T> T fromJson(@NotNull String json, @NotNull Class<T> clazz) {
        try {
            LogManager.getLogger().debug(clazz + ":" + json);
            return GSON.fromJson(json, clazz);
        } catch (Exception e) {
            LogManager.getLogger().debug(null, e);
            return null;
        }
    }

    @NotNull
    public <T> String toJson(@NotNull T object) {
        return GSON.toJson(object);
    }
}
