package com.potopalskyi.webserver.util;

import org.junit.Test;

import java.io.FileNotFoundException;

public class ResourceReaderTest {

    @Test
    public void getResourceExistTest() throws FileNotFoundException {
        String url = "/Hello.html";
        String resource = "src\\test\\resources";
        ResourceReader resourceReader = new ResourceReader();
        resourceReader.setPathToResource(resource);
        resourceReader.getResource(url);
    }

    @Test(expected = FileNotFoundException.class)
    public void getResourceDoesnExistTest() throws FileNotFoundException {
        String url = "/DoesnotExist.html";
        String resource = "src\\test\\resources";
        ResourceReader resourceReader = new ResourceReader();
        resourceReader.setPathToResource(resource);
        resourceReader.getResource(url);
    }
}
