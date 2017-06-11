package com.potopalskyi.dto;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private HttpMethod method;
    private String url;
    private Map<String, String> headers = new HashMap<>();

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
