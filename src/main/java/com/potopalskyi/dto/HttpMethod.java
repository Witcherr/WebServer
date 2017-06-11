package com.potopalskyi.dto;

public enum HttpMethod {
    GET("GET"), POST("POST");

    private String name;

    HttpMethod(String name){
        this.name = name;
    }

    public static HttpMethod getByValue(String val) {
        for (HttpMethod c : values()) {
            if (c.name.equals(val)) {
                return c;
            }
        }
        return null;
    }
}
