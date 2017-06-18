package com.potopalskyi.webserver.server;

import com.potopalskyi.webserver.util.ResourceReader;
import com.potopalskyi.webserver.handler.RequestHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private int port;
    private ResourceReader resourceReader = new ResourceReader();

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)
            ) {
                RequestHandler requestHandler = new RequestHandler(bufferedReader, resourceReader, bufferedOutputStream);
                requestHandler.handle();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setPathToResource(String path) {
        resourceReader.setPathToResource(path);
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
