package com.potopalskyi.webserver.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HttpMethodTest {

    @Test(expected=IllegalArgumentException.class)
    public void getByValueTest(){
        HttpMethod.getByValue("UPDATE");
    }

    @Test
    public void getByValueGetTest(){
        Request request = new Request();
        request.setMethod(HttpMethod.getByValue("GET"));
        assertEquals(HttpMethod.GET, request.getMethod());
    }

}
