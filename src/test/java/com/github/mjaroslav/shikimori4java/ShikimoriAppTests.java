package com.github.mjaroslav.shikimori4java;

import com.github.mjaroslav.shikimori4java.object.Anime;
import com.github.mjaroslav.shikimori4java.throwable.login.LoginErrorException;
import com.github.mjaroslav.shikimori4java.throwable.runtime.AuthRequiredException;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ShikimoriAppTests {
    private static ShikimoriApp app;

    @BeforeAll
    public static void login() throws LoginErrorException {
        app = new ShikimoriApp("Shikimori4JavaTest");
        app.loginAsPublic();
    }

    @Test
    public void animes_id() {
        val expected = "Cowboy Bebop";
        val response = app.animes().id(1).execute();
        val actual = response.name;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void animes_search() {
        val expected = "Trigun";
        Anime[] response = app.animes().search("Trigun", 1).execute();
        val actual = response[0].name;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void users_whoami_fail() {
        Assertions.assertThrows(AuthRequiredException.class, () -> app.users().whoami().execute());
    }

    @Test
    public void many_requests() {
        for (int i = 0; i < 7; i++)
            new Thread(() -> {
                val actual = app.animes().id(1).execute().name;
                Assertions.assertEquals("Cowboy Bebop", actual);
            }).start();
    }
}
