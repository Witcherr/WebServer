package com.potopalskyi.webserver.dto;

public enum HttpMethod {
    GET("GET"), POST("POST");

    private String name;

    HttpMethod(String name) {
        this.name = name;
    }

    public static HttpMethod getByValue(String value) {
        for (HttpMethod method : values()) {
            if (method.name.equals(value)) {
                return method;
            }
        }
        throw new IllegalArgumentException("No HttpMethod found for value: " + value);
    }

    @Override
    public String toString() {
        return "HttpMethod{" +
                "name='" + name + '\'' +
                '}';
    }
}
