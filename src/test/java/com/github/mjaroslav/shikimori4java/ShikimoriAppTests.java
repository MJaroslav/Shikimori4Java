package com.github.mjaroslav.shikimori4java;

import com.github.mjaroslav.shikimori4java.util.TestAuthHandler;
import lombok.val;
import org.junit.jupiter.api.Test;

public class ShikimoriAppTests {
    @Test
    public void test() throws Exception {
        val auth = new TestAuthHandler();
        val app = new ShikimoriApp(auth.getName(), auth.getClientId(), auth.getClientSecret(), null);
        app.setAuthHandler(auth);
        app.login();
        System.out.println(app.animes().id(1).execute().name);
    }
}
