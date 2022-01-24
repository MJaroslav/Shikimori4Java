package com.github.mjaroslav.shikimori4java;

import com.github.mjaroslav.shikimori4java.util.TestAuthHandler;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ShikimoriAppTests {
    private static ShikimoriApp app;

    @BeforeAll
    public static void login() throws Exception {
        val auth = new TestAuthHandler();
        app = new ShikimoriApp(auth.getName(), auth.getClientId(), auth.getClientSecret(), null);
        app.setAuthHandler(auth);
        Assertions.assertTrue(app.login(), "Can't login!");
    }

    @Test
    public void animes_id() {
        val expected = "Cowboy Bebop";
        val response = app.animes().id(1).execute();
        app.getLogger().debug(response.toString());
        val actual = response.name;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void animes_search() {
        val expected = "Trigun";
        val response = app.animes().search("Trigun", 1).execute();
        app.getLogger().debug(Arrays.toString(response));
        val actual = response[0].name;
        Assertions.assertEquals(expected, actual);
    }
}
