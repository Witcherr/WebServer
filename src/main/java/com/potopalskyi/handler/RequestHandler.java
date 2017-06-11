package com.potopalskyi.handler;

import com.potopalskyi.common.Constant;
import com.potopalskyi.util.RequestParser;
import com.potopalskyi.util.ResourceReader;
import com.potopalskyi.dto.Request;
import com.potopalskyi.util.ResourceWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class RequestHandler {

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private ResourceReader resourceReader;

    public RequestHandler(BufferedReader bufferedReader, BufferedWriter bufferedWriter, ResourceReader resourceReader) {
        this.bufferedReader = bufferedReader;
        this.bufferedWriter = bufferedWriter;
        this.resourceReader = resourceReader;
    }

    public void handle() throws IOException {
        Request request = RequestParser.parseRequest(bufferedReader);
        if(!Constant.FAVICON.contains(request.getUrl())){
            BufferedReader content = resourceReader.getResourse(request.getUrl());
            ResourceWriter.writeResponse(content, bufferedWriter);
        }
    }
}
