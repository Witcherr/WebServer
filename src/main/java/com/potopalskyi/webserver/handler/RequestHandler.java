package com.potopalskyi.webserver.handler;

import com.potopalskyi.webserver.common.Constant;
import com.potopalskyi.webserver.util.RequestParser;
import com.potopalskyi.webserver.util.ResourceReader;
import com.potopalskyi.webserver.dto.Request;
import com.potopalskyi.webserver.util.ResourceWriter;

import java.io.*;

public class RequestHandler {
    private BufferedReader bufferedReader;
    private BufferedOutputStream bufferedOutputStream;
    private ResourceReader resourceReader;

    public RequestHandler(BufferedReader bufferedReader, ResourceReader resourceReader, BufferedOutputStream bufferedOutputStream) {
        this.bufferedReader = bufferedReader;
        this.resourceReader = resourceReader;
        this.bufferedOutputStream = bufferedOutputStream;
    }

    public void handle() throws IOException {
        Request request = RequestParser.parseRequest(bufferedReader);

        try (BufferedInputStream content = resourceReader.getResource(request.getUrl())) {
            System.out.println("Writing response for request : " + request);
            ResourceWriter.writeResponse(Constant.OK_STATUS, content, bufferedOutputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Page was not found for request : " + request);
            ResourceWriter.writeResponse(Constant.NOT_FOUND_STATUS, bufferedOutputStream);
        }finally {
            bufferedOutputStream.close();
        }
    }
}
