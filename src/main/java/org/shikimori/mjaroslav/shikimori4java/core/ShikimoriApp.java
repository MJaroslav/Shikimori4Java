package org.shikimori.mjaroslav.shikimori4java.core;

import org.shikimori.mjaroslav.shikimori4java.api.ApiAnimes;
import org.shikimori.mjaroslav.shikimori4java.api.ApiMangas;
import org.shikimori.mjaroslav.shikimori4java.api.ApiUsers;
import org.shikimori.mjaroslav.shikimori4java.object.ObjectAccessToken;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;

public class ShikimoriApp {
	private static final Gson gson = new Gson();

	private String appName;
	private String clientId;
	private String clientSecret;
	private String redirectUri = ShikimoriInfo.REDIRECTURI;
	private String responseType = "code";
	private String grantType = "authorization_code";
	private String username;

	private IAuthWrapper authWrapper = new DefaultAuthWrapper();
	private ITokenStorage tokenStorage = new DefaultTokenStorage();

	private ShikimoriClient client;

	private ApiAnimes animes = new ApiAnimes(this);
	private ApiMangas mangas = new ApiMangas(this);
	private ApiUsers users = new ApiUsers(this);

	public ShikimoriApp(String name, String clientId, String clientSecret) {
		this.appName = name;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	public ShikimoriApp setAuthWrapper(IAuthWrapper authWrapper) {
		this.authWrapper = authWrapper;
		return this;
	}

	public ShikimoriApp setTokenStorage(ITokenStorage tokenStorage) {
		this.tokenStorage = tokenStorage;
		return this;
	}

	public ShikimoriApp setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
		return this;
	}

	public String getAppName() {
		return appName;
	}

	public IAuthWrapper getAuthWrapper() {
		return authWrapper;
	}

	public ShikimoriClient getClient() {
		return client;
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getGrantType() {
		return grantType;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public String getResponseType() {
		return responseType;
	}

	public ITokenStorage getTokenStorage() {
		return tokenStorage;
	}

	public HttpRequest createCodeRequest() {
		return HttpRequest.get(ShikimoriInfo.AUTHORIZE, true, "client_id", getClientId(), "redirect_uri",
				getRedirectUri(), "response_type", getResponseType());
	}

	public HttpRequest createTokenRequest(String code) {
		return HttpRequest
				.post(ShikimoriInfo.TOKEN, true, "grant_type", getGrantType(), "client_id", getClientId(),
						"client_secret", getClientSecret(), "code", code, "redirect_uri", getRedirectUri())
				.userAgent(getUserAgent());
	}

	public ShikimoriClient auth(String nickname) throws Exception {
		ObjectAccessToken token = tokenStorage.loadToken(appName, nickname);
		this.username = nickname;
		client = new ShikimoriClient(this, token.accessToken);
		return client;
	}

	public ShikimoriClient auth() throws Exception {
		authWrapper.sendRequest(createCodeRequest().url());
		ObjectAccessToken token = gson.fromJson(createTokenRequest(authWrapper.getResponse()).body(),
				ObjectAccessToken.class);
		if (token.isLogged()) {
			username = users().whoami().execute().nickname;
			tokenStorage.saveToken(appName, getUsername(), token);
			client = new ShikimoriClient(this, token.accessToken);
			return client;
		} else
			throw new Exception(token.error + ": " + token.errorDesc);
	}

	public String getUserAgent() {
		return getAppName();
	}

	public String getUsername() {
		return username;
	}

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
