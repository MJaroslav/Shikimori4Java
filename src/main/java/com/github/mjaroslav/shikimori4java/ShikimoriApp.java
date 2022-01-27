package com.github.mjaroslav.shikimori4java;

import com.github.mjaroslav.shikimori4java.api.Animes;
import com.github.mjaroslav.shikimori4java.api.Mangas;
import com.github.mjaroslav.shikimori4java.api.Users;
import com.github.mjaroslav.shikimori4java.auth.AuthHandler;
import com.github.mjaroslav.shikimori4java.auth.TokenStorage;
import com.github.mjaroslav.shikimori4java.auth.impl.DefaultAuthHandler;
import com.github.mjaroslav.shikimori4java.auth.impl.DefaultTokenStorage;
import com.github.mjaroslav.shikimori4java.logger.LogManager;
import com.github.mjaroslav.shikimori4java.object.AccessToken;
import com.github.mjaroslav.shikimori4java.object.User;
import com.github.mjaroslav.shikimori4java.object.UserExtended;
import com.github.mjaroslav.shikimori4java.throwable.login.AlreadyLoggedException;
import com.github.mjaroslav.shikimori4java.throwable.login.LoginErrorException;
import com.github.mjaroslav.shikimori4java.throwable.token.TokenErrorException;
import com.github.mjaroslav.shikimori4java.util.Utils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

@Getter
@Setter
public class ShikimoriApp {
    @UnknownNullability
    private final String appName, clientId, clientSecret, redirectUri;

    @NotNull
    private AuthHandler authHandler = new DefaultAuthHandler();
    @NotNull
    private TokenStorage tokenStorage = new DefaultTokenStorage();

    @Setter(AccessLevel.NONE)
    private String nickname;
    @Setter(AccessLevel.NONE)
    private int userId;

    @Setter(AccessLevel.NONE)
    private boolean publicApiOnly;

    private final Animes animes = new Animes(this);
    private final Mangas mangas = new Mangas(this);
    private final Users users = new Users(this);

    private boolean refreshOnError = true;

    @Setter(AccessLevel.NONE)
    private boolean logged;

    public ShikimoriApp(@NotNull String name, @NotNull String clientId, @NotNull String clientSecret,
                        @Nullable String redirectUri, @Nullable AuthHandler authHandler, @Nullable TokenStorage tokenStorage) {
        appName = name;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = Utils.stringNotEmpty(redirectUri) ? redirectUri : ShikimoriInfo.REDIRECT_URI_DEFAULT;
        if (authHandler != null) this.authHandler = authHandler;
        if (tokenStorage != null) this.tokenStorage = tokenStorage;
    }

    public ShikimoriApp(@NotNull String name) {
        this.appName = name;
        clientId = clientSecret = redirectUri = null;
    }

    public void loginAsPublic() throws LoginErrorException {
        if (logged)
            throw new AlreadyLoggedException();
        publicApiOnly = true;
        LogManager.getLogger().info("Logged for only public API requests");
        logged = true;
    }

    public void refreshToken(boolean force) throws LoginErrorException {
        if (force || authHandler.isRefreshRequired()) {
            LogManager.getLogger().warn("Token refreshing required, try to do it...");
            authHandler.refreshToken(clientId, clientSecret, appName, authHandler.getToken().refreshToken);
            try {
                tokenStorage.saveToken(authHandler.getToken());
            } catch (Exception e) {
                LogManager.getLogger().error("Can't save token", e);
            }
        }
        if (authHandler.isAuthorized()) {
            initUser();
            logged = true;
        } else logged = false;
    }

    public void loginAsUser() throws LoginErrorException, TokenErrorException {
        if (logged)
            throw new AlreadyLoggedException();
        AccessToken token;
        LogManager.getLogger().debug("Loading token from storage...");
        token = tokenStorage.loadToken();
        if (token == null) {
            authHandler.auth(clientId, clientSecret, redirectUri, appName);
            LogManager.getLogger().debug("Saving new token to storage...");
            tokenStorage.saveToken(authHandler.getToken());
        } else {
            authHandler.setToken(token);
        }
        refreshToken(false);
    }

    private void initUser() {
        val user = getUser();
        nickname = user.nickname;
        userId = user.id;
    }

    @NotNull
    public UserExtended getUser() {
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
