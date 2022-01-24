package com.github.mjaroslav.shikimori4java;

import com.github.mjaroslav.shikimori4java.api.Animes;
import com.github.mjaroslav.shikimori4java.api.Mangas;
import com.github.mjaroslav.shikimori4java.api.Users;
import com.github.mjaroslav.shikimori4java.auth.AuthHandler;
import com.github.mjaroslav.shikimori4java.auth.TokenStorage;
import com.github.mjaroslav.shikimori4java.auth.impl.DefaultAuthHandler;
import com.github.mjaroslav.shikimori4java.auth.impl.DefaultTokenStorage;
import com.github.mjaroslav.shikimori4java.object.UserExtended;
import com.github.mjaroslav.shikimori4java.object.User;
import com.github.mjaroslav.shikimori4java.logger.Logger;
import com.github.mjaroslav.shikimori4java.throwable.ShikimoriException;
import com.github.mjaroslav.shikimori4java.util.Utils;
import com.github.mjaroslav.shikimori4java.logger.impl.DefaultLogger;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
public class ShikimoriApp {
    @NotNull
    private final String appName, clientId, clientSecret, redirectUri;

    @NotNull
    private AuthHandler authHandler = new DefaultAuthHandler();
    @NotNull
    private TokenStorage tokenStorage = new DefaultTokenStorage();
    @NotNull
    private Logger logger = new DefaultLogger();

    @Setter(AccessLevel.NONE)
    private String nickname;
    @Setter(AccessLevel.NONE)
    private int userId;

    private final Animes animes = new Animes(this);
    private final Mangas mangas = new Mangas(this);
    private final Users users = new Users(this);

    private boolean refreshOnError = true;

    public ShikimoriApp(@NotNull String name, @NotNull String clientId, @NotNull String clientSecret,
                        @Nullable String redirectUri) {
        appName = name;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = Utils.stringNotEmpty(redirectUri) ? redirectUri : ShikimoriInfo.REDIRECT_URI_DEFAULT;
    }

    public boolean login() {
        try {
            authHandler.setToken(tokenStorage.loadToken());
        } catch (Exception e) {
            logger.info("Can't load token, trying to create new...", e);
            if (!authHandler.auth(clientId, clientSecret, redirectUri, appName))
                return false;
            else {
                try {
                    tokenStorage.saveToken(authHandler.getToken());
                } catch (Exception ex) {
                    logger.error("Can't save token", ex);
                }
            }
        }
        if (authHandler.isRefreshRequired()) {
            logger.warn("Token refreshing required, try to do it...");
            if (!authHandler.refreshToken(clientId, clientSecret, appName, authHandler.getToken().refreshToken))
                return false;
            try {
                tokenStorage.saveToken(authHandler.getToken());
            } catch (Exception e) {
                logger.error("Can't save token", e);
            }
        }
        if (authHandler.isAuthorized()) {
            initUser();
            return true;
        } else return false;
    }

    private void initUser() throws ShikimoriException {
        val user = getUser();
        nickname = user.nickname;
        userId = user.id;
    }

    @NotNull
    public UserExtended getUser() throws ShikimoriException {
        if (userId <= 0) {
            User me = users().whoami().execute();
            return users().id(me.id).execute();
        } else
            return users().id(userId).execute();
    }

    @NotNull
    public String getAuthorization() {
        return "Bearer " + authHandler.getToken().accessToken;
    }

    @NotNull
    public Animes animes() {
        return animes;
    }

    @NotNull
    public Mangas mangas() {
        return mangas;
    }

    @NotNull
    public Users users() {
        return users;
    }
}
