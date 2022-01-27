# Shikimori4Java
SDK for shikimori api (https://shikimori.one/api/doc)

[![](https://jitpack.io/v/MJaroslav/Shikimori4Java.svg)](https://jitpack.io/#MJaroslav/Shikimori4Java)
[![](https://jitci.com/gh/MJaroslav/Shikimori4Java/svg)](https://jitci.com/gh/MJaroslav/Shikimori4Java)

## Examples
Public requests:
```java
package example;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;

public class ExamplePublic {
    public static void main(String... args) throws Exception {
        // Your oauth application name
        // (you can be banned by API server without this)
        String appName = args[0];
        
        // Creating public API requester (you can't use
        // user-depends methods)
        ShikimoriApp app = new ShikimoriApp(appName);
        app.loginAsPublic();
        
        // Call /api/animes/1 method
        Anime response = app.animes().id(1).execute();
        System.out.println(response);
    }
}
```
User requests:

```java
package example;

import com.github.mjaroslav.shikimori4java.ShikimoriApp;
import com.github.mjaroslav.shikimori4java.ShikimoriInfo;
import com.github.mjaroslav.shikimori4java.auth.AuthHandler;
import com.github.mjaroslav.shikimori4java.auth.TokenStorage;
import com.github.mjaroslav.shikimori4java.object.User;

public class ExampleUser {
    public static void main(String... args) throws Exception {
        // Your oauth application name
        // (you can be banned by API server without this)
        String appName = args[0];
        // Your oauth application information, this required
        // for auth and requesting
        String clientId = args[1];
        String clientSecret = args[2];
        // Can be null for default value
        String redirectUri = null;
        // Can be null for default realization
        // (its open browser and wait auth code for
        // in console
        AuthHandler authHandler = null;
        // Can be null for default realization
        // (its save token in ./token.json file) 
        TokenStorage tokenStorage = null;

        // Creating user requester (you can use
        // all API methods from allowed scopes)
        ShikimoriApp app = new ShikimoriApp(appName, clientId, clientSecret, redirectUri, );
        app.loginAsPublic();

        // Call /api/users/whoami method
        User response = app.users().whoami();
        System.out.println(response);
    }
}
```
