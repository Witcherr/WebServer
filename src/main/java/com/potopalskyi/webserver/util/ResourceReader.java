package com.potopalskyi.webserver.util;

import java.io.*;

public class ResourceReader {

    private String pathToResource;

    public BufferedInputStream getResource(String url) throws FileNotFoundException {
        String filePath = pathToResource.concat(url);
        return new BufferedInputStream(new FileInputStream(filePath));
    }

    public String getPathToResource() {
        return pathToResource;
    }

    public void setPathToResource(String pathToResource) {
        this.pathToResource = pathToResource;
    }
}
