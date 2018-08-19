package org.shikimori.mjaroslav.shikimori4java.core;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class DefaultAuthWrapper implements IAuthWrapper {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String getResponse() {
        System.out.println("Enter code:");
        return scanner.nextLine();
    }

    @Override
    public void sendRequest(URL url) {
        if (Desktop.isDesktopSupported())
            try {
                System.out.println(url.toString());
                Desktop.getDesktop().browse(url.toURI());
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
    }
}
