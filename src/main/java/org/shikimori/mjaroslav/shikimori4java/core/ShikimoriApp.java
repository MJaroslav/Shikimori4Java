package org.shikimori.mjaroslav.shikimori4java.core;

import org.shikimori.mjaroslav.shikimori4java.api.ApiAnimes;
import org.shikimori.mjaroslav.shikimori4java.api.ApiMangas;
import org.shikimori.mjaroslav.shikimori4java.api.ApiUsers;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectAccessToken;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectUserFull;
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
	private IAuthWrapper authWrapper = new DefaultAuthWrapper();
	private ITokenStorage tokenStorage = new DefaultTokenStorage();

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

	public ShikimoriApp(String name, String clientId, String clientSecret) {
		this.appName = name;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	public void setAuthWrapper(IAuthWrapper authWrapper) {
		this.authWrapper = authWrapper;
	}

	public void setTokenStorage(ITokenStorage tokenStorage) {
		this.tokenStorage = tokenStorage;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getAppName() {
		return appName;
	}

	public IAuthWrapper getAuthWrapper() {
		return authWrapper;
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

	public ITokenStorage getTokenStorage() {
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

	public void auth(String nickname) throws Exception {
		this.token = tokenStorage.loadToken(appName, nickname);
		initUser();
		if (!Utils.stringNotEmpty(getUsername()))
			refreshToken();
	}

	public void auth() throws Exception {
		authWrapper.sendRequest(createCodeRequest().url());
		ObjectAccessToken token = Utils.fromJson(createTokenRequest(authWrapper.getResponse()).body(),
				ObjectAccessToken.class);
		if (token.isLogged()) {
			this.token = token;
			initUser();
			tokenStorage.saveToken(appName, getUsername(), token);
		} else
			throw new Exception(token.error + ": " + token.errorDesc);
	}

	public HttpRequest createRefreshTokenRequest() {
		return HttpRequest
				.post(ShikimoriInfo.TOKEN, true, "grant_type", ShikimoriInfo.GRANT_TYPE_REFRESH, "client_id",
						getClientId(), "client_secret", getClientSecret(), "refresh_token", getToken().refreshToken)
				.userAgent(getUserAgent());
	}

	public void refreshToken() throws Exception {
		HttpRequest req = createRefreshTokenRequest();
		String json = req.body();
		System.out.println(json + "\n" + req.url());
		ObjectAccessToken token = Utils.fromJson(json, ObjectAccessToken.class);
		if (token.isLogged()) {
			this.token = token;
			initUser();
			tokenStorage.saveToken(appName, getUsername(), token);
		} else
			throw new Exception(token.error + ": " + token.errorDesc);
	}

	public void initUser() {
		ObjectUserFull user = getUser();
		username = user.nickname;
		userId = user.id;
	}

	public ObjectUserFull getUser() {
		//if (userId <= 0) {
			return users().whoami().execute();
		/*} else
			return null;*/
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
}
