package com.github.mjaroslav.shikimori4java.util;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.api.SyntaxError;
import com.github.mjaroslav.shikimori4java.object.Image;
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
    public final Jankson JANKSON = Jankson.builder().registerDeserializer(JsonObject.class, Image.class,
            new ImageDeserializer()).build();

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
            return JANKSON.getMarshaller().marshall(clazz, JANKSON.loadElement(json));
        } catch (SyntaxError e) {
            return null;
        }
    }

    @NotNull
    public <T> String toJson(@NotNull T object) {
        return JANKSON.toJson(object).toJson();
    }
}
