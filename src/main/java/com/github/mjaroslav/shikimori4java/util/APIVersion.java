package com.github.mjaroslav.shikimori4java.util;

import com.github.mjaroslav.shikimori4java.ShikimoriInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public enum APIVersion {
    V1(ShikimoriInfo.URL_API_V1), V2(ShikimoriInfo.URL_API_V2);

    @Getter
    @NotNull
    private final String url;
}
