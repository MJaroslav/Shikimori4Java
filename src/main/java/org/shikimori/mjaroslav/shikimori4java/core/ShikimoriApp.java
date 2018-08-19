package org.shikimori.mjaroslav.shikimori4java.core;

import java.nio.charset.StandardCharsets;

import org.shikimori.mjaroslav.shikimori4java.api.ApiAnimes;
import org.shikimori.mjaroslav.shikimori4java.api.ApiMangas;
import org.shikimori.mjaroslav.shikimori4java.api.ApiUsers;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectAccessToken;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectUserFull;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectUserMe;
import org.shikimori.mjaroslav.shikimori4java.utils.ShikimoriException;
import org.shikimori.mjaroslav.shikimori4java.utils.Utils;

import com.github.kevinsawicki.http.HttpRequest;

public class ShikimoriApp {
    //
    // APP DATA
    //
    private String appName;
    private String clientId;
    private String clientSecret;
    private String redirectUri = ShikimoriInfo.REDIRECT_URI;

    //
    // APP UTILS
    //
    private IAuthWrapper authWrapper;
    private ITokenStorage tokenStorage;
    private IAppLogger appLogger;

    //
    // USER DATA
    //
    private ObjectAccessToken token;
    private String username;
    private int userId;

    //
    // APIES
    //
    private ApiAnimes animes = new ApiAnimes(this);
    private ApiMangas mangas = new ApiMangas(this);
    private ApiUsers users = new ApiUsers(this);

    //
    // APP OPTIONS
    //
    private boolean refreshTokenOnRequestError = true;

    /**
     * Create new wrapper object for shikimori application.
     * 
     * @param name         Use application name from shikimori applications page.
     * @param clientId     Application client ID. See on /edit page of application.
     * @param clientSecret Application client secret code. See on /edit page of
     *                     application.
     */
    public ShikimoriApp(String name, String clientId, String clientSecret) {
        this.appName = name;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public void setAuthWrapper(IAuthWrapper authWrapper) {
        this.authWrapper = authWrapper;
        getAppLogger().debug("Auth wrapper replaced to: " + getAuthWrapper().getClass());
    }

    public void setTokenStorage(ITokenStorage tokenStorage) {
        this.tokenStorage = tokenStorage;
        getAppLogger().debug("Token storage replaced to: " + getTokenStorage().getClass());
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        getAppLogger().debug("Redirect URI replaced to: " + redirectUri);
    }

    public void setAppLogger(IAppLogger appLogger) {
        this.appLogger = appLogger;
        getAppLogger().info("App logger replaced to: " + getAppLogger().getClass());
    }

    public String getAppName() {
        return appName;
    }

    public IAuthWrapper getAuthWrapper() {
        if (authWrapper == null)
            authWrapper = new DefaultAuthWrapper();
        return authWrapper;
    }

    public void canRefreshTokenOnRequestError(boolean can) {
        this.refreshTokenOnRequestError = can;
    }

    public boolean canRefreshTokenOnRequestError() {
        return refreshTokenOnRequestError;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public IAppLogger getAppLogger() {
        if (appLogger == null)
            try {
                appLogger = new DefaultLog4jAppLogger(this);
            } catch (Exception e) {
                appLogger = new DefaultSystemAppLogger();
            }
        return appLogger;
    }

    public ITokenStorage getTokenStorage() {
        if (tokenStorage == null)
            tokenStorage = new DefaultTokenStorage();
        return tokenStorage;
    }

    public HttpRequest createCodeRequest() {
        return HttpRequest.get(ShikimoriInfo.AUTHORIZE, true, "client_id", getClientId(), "redirect_uri",
                getRedirectUri(), "response_type", ShikimoriInfo.RESPONSE_TYPE);
    }

    public HttpRequest createTokenRequest(String code) {
        return HttpRequest.post(ShikimoriInfo.TOKEN, true, "grant_type", ShikimoriInfo.GRANT_TYPE_CODE, "client_id",
                getClientId(), "client_secret", getClientSecret(), "code", code, "redirect_uri", getRedirectUri())
                .userAgent(getUserAgent());
    }

    public void auth(String nickname, boolean reloginOnError) throws Exception {
        try {
            this.token = getTokenStorage().loadToken(appName, nickname);
        } catch (Exception e) {
            if (reloginOnError) {
                getAppLogger().info("Relogin for " + nickname);
                auth();
                return;
            } else
                throw new ShikimoriException("Token for " + nickname + " not found!");
        }
        try {
            initUser();
        } catch (Exception e) {
            if (e instanceof ShikimoriException && ((ShikimoriException) e).isAuthError()) {
                getAppLogger().debug("Refreshing token for " + nickname);
                refreshToken();
            } else
                throw new ShikimoriException("Can't refresh token for " + nickname);
        }
        getAppLogger().info(getAppName() + " app logged for " + username);
    }

    public void auth() throws Exception {
        getAuthWrapper().sendRequest(createCodeRequest().url());
        ObjectAccessToken token = Utils.fromJson(createTokenRequest(getAuthWrapper().getResponse()).body(),
                ObjectAccessToken.class);
        if (!token.hasError()) {
            this.token = token;
            initUser();
            getTokenStorage().saveToken(appName, getUsername(), token);
        } else
            throw new ShikimoriException(token);
        getAppLogger().info(getAppName() + " app logged for " + username);
    }

    public HttpRequest createRefreshTokenRequest() {
        return HttpRequest
                .post(ShikimoriInfo.TOKEN, true, "grant_type", ShikimoriInfo.GRANT_TYPE_REFRESH, "client_id",
                        getClientId(), "client_secret", getClientSecret(), "refresh_token", getToken().refreshToken)
                .userAgent(getUserAgent());
    }

    public void refreshToken() throws Exception {
        HttpRequest req = createRefreshTokenRequest();
        ObjectAccessToken token = Utils.fromJson(req.body(StandardCharsets.UTF_8.name()), ObjectAccessToken.class);
        if (!token.hasError()) {
            this.token = token;
            initUser();
            getTokenStorage().saveToken(appName, getUsername(), token);
        } else
            throw new ShikimoriException(token);
    }

    public void initUser() throws ShikimoriException {
        ObjectUserFull user = getUser();
        if (!Utils.stringNotEmpty(user.nickname))
            throw new ShikimoriException("Can't get user for " + getAppName() + " app!", true);
        username = user.nickname;
        userId = user.id;
    }

    public ObjectUserFull getUser() throws ShikimoriException {
        if (userId <= 0) {
            ObjectUserMe me = users().whoami().execute();
            return users().id(me.id).execute();
        } else
            return users().id(userId).execute();
    }

    public int getUserId() {
        return userId;
    }

    public String getUserAgent() {
        return getAppName();
    }

    public String getAuthorization() {
        return "Bearer " + getToken().accessToken;
    }

    public String getUsername() {
        return username;
    }

    public ObjectAccessToken getToken() {
        return token;
    }

    //
    // API GETTERS
    //

    public ApiAnimes animes() {
        return animes;
    }

    public ApiMangas mangas() {
        return mangas;
    }

    public ApiUsers users() {
        return users;
    }

    public void resetTokenForTests() {
        token.accessToken = "null";
    }
}
