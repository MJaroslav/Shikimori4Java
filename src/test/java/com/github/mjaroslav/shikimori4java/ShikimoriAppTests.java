package com.github.mjaroslav.shikimori4java;

import com.github.mjaroslav.shikimori4java.util.TestAuthHandler;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ShikimoriAppTests {
    private static ShikimoriApp app;

    @BeforeAll
    public static void login() throws Exception {
        val auth = new TestAuthHandler();
        app = new ShikimoriApp(auth.getName(), auth.getClientId(), auth.getClientSecret(), null);
        app.setAuthHandler(auth);
        app.login();
    }

    @Test
    public void animes_id() {
        val expected = "Cowboy Bebop";
        val actual = app.animes().id(1).execute().name;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void animes_search() {
        val expected = "Trigun";
        val actual = app.animes().search("Trigun", 1).execute()[0].name;
        Assertions.assertEquals(expected, actual);
    }
}
