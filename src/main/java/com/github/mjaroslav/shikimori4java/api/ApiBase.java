package com.github.mjaroslav.shikimori4java.api;

import com.github.mjaroslav.shikimori4java.core.ShikimoriApp;

public abstract class ApiBase {
    private ShikimoriApp app;

    public ApiBase(ShikimoriApp app) {
        this.app = app;
    }

    public ShikimoriApp getApp() {
        return app;
    }
}
