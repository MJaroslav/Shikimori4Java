package com.github.mjaroslav.shikimori4java;

import com.github.mjaroslav.shikimori4java.throwable.login.LoginErrorException;
import com.github.mjaroslav.shikimori4java.throwable.token.TokenErrorException;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CIShikimoriAppTests {
    private static ShikimoriApp app;

    @BeforeAll
    public static void login() throws LoginErrorException, TokenErrorException {
        val appName = System.getenv("APP_NAME");
        val clientId = System.getenv("CLIENT_ID");
        val clientSecret = System.getenv("CLIENT_SECRET_PASSWORD");
        app = new ShikimoriApp(appName, clientId, clientSecret, null, new CIAuthHandler(), null);
        app.loginAsUser();
    }

    @Test
    public void test_whoami() {
        val user = app.users().whoami().execute();
        Assertions.assertEquals("MJaroslav", user.nickname);
    }
}
