package com.github.mjaroslav.shikimori4java.util;

import blue.endless.jankson.JsonObject;
import blue.endless.jankson.api.DeserializerFunction;
import blue.endless.jankson.api.Marshaller;
import com.github.mjaroslav.shikimori4java.object.Image;
import lombok.val;

public final class ImageDeserializer implements DeserializerFunction<JsonObject, Image> {
    @Override
    public Image apply(JsonObject object, Marshaller m) {
        val result = new Image();
        result.original = object.get(String.class, "original");
        result.preview = object.get(String.class, "preview");
        object.entrySet().stream().filter(entry -> entry.getKey().startsWith("x"))
                .forEach(entry -> result.xSizes.put(entry.getKey(), entry.getValue().toString()));
        return result;
    }
}
