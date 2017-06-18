package com.potopalskyi.webserver.util;

import com.potopalskyi.webserver.common.Constant;

import java.io.*;

public class ResourceWriter {

    private static void writeResponseStatus(String status, BufferedOutputStream clientWriter) throws IOException {
        byte[] arrayBytes = status.getBytes();
        int length = arrayBytes.length;
        clientWriter.write(arrayBytes, 0, length);
        arrayBytes = Constant.NEW_LINE.getBytes();
        length = arrayBytes.length;
        clientWriter.write(arrayBytes, 0, length);
        clientWriter.write(arrayBytes, 0, length);
    }

    private static void writeResponseBody(BufferedInputStream content, BufferedOutputStream clientWriter) throws IOException {
        byte[] buf = new byte[1024];
        int len;
        while ((len = content.read(buf)) >= 0) {
            clientWriter.write(buf, 0, len);
        }
    }

    public static void writeResponse(String status, BufferedInputStream content, BufferedOutputStream clientWriter) throws IOException {
        writeResponseStatus(status, clientWriter);
        writeResponseBody(content, clientWriter);
    }

    public static void writeResponse(String status, BufferedOutputStream clientWriter) throws IOException {
        writeResponseStatus(status, clientWriter);
    }
}
