package com.potopalskyi.server;

import org.junit.Test;

import java.io.IOException;

public class WebServerTest {

    @Test
    public void startTest() throws IOException {
        WebServer webServer = new WebServer();
        int port = 3000;
        //String resource = "E:\\Oleg\\Java\\Study_projects\\WebServer\\src\\test\\resources";
        String resource = "E:\\Oleg\\Java\\Study_projects\\WebServer\\src\\test\\resources\\new_folder";
        webServer.setPort(port);
        webServer.setPathToResource(resource);
        webServer.start();
    }
}
