package org.shikimori.mjaroslav.shikimori4java.core;

import java.net.URL;

public interface IAuthWrapper {
    public void sendRequest(URL url) throws Exception;

    public String getResponse() throws Exception;
}
