package org.shikimori.mjaroslav.shikimori4java;

import org.shikimori.mjaroslav.shikimori4java.core.ShikimoriApp;

public class Shikimori4Java {
    public static void main(String... args) {
        ShikimoriApp app = new ShikimoriApp(args[0], args[1], args[2]);
        try {
            app.auth("MJaroslav", true);
            app.getAppLogger().info(app.getUser().nickname);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
