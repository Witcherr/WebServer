package com.potopalskyi.webserver.server;

import org.junit.Test;

import java.io.IOException;

public class WebServerTest {

    @Test
    public void startTest() throws IOException {
        WebServer webServer = new WebServer();
        String resource = "src\\test\\resources\\new_folder";
        webServer.setPort(3000);
        webServer.setPathToResource(resource);
        webServer.start();
    }
}
