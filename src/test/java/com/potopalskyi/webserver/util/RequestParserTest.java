package com.potopalskyi.webserver.util;

import com.potopalskyi.webserver.dto.HttpMethod;
import com.potopalskyi.webserver.dto.Request;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class RequestParserTest {

    @Test
    public void parseRequestTest() throws IOException {
        String testRequestGet = "GET /Volleyball.html HTTP/1.1\n" +
                "Host: localhost:3000\n" +
                "Connection: keep-alive\n" +
                "Cache-Control: max-age=0  \n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36\n" +
                "\n";

        InputStream inputStream = new ByteArrayInputStream(testRequestGet.getBytes());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        Request request = RequestParser.parseRequest(bufferedReader);
        assertEquals(HttpMethod.GET, request.getMethod());
        assertEquals("/Volleyball.html", request.getUrl());
        assertEquals("max-age=0", request.getHeaders().get("Cache-Control"));

        String testRequestPost = "POST /Volleyball.html HTTP/1.1\n" +
                "Host: localhost:3000\n" +
                "\n";

        inputStream = new ByteArrayInputStream(testRequestPost.getBytes());
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        request = RequestParser.parseRequest(bufferedReader);
        assertEquals(HttpMethod.POST, request.getMethod());
        assertEquals("/Volleyball.html", request.getUrl());
        assertEquals("localhost:3000", request.getHeaders().get("Host"));


    }


    @Test(expected=IllegalArgumentException.class)
    public void parseRequestUpdateTest() throws IOException {
        String testRequestUpdate = "UPDATE /Volleyball.html HTTP/1.1\n" +
                "Host: localhost:3000\n" +
                "\n";

        InputStream inputStream = new ByteArrayInputStream(testRequestUpdate.getBytes());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        RequestParser.parseRequest(bufferedReader);
    }
}
