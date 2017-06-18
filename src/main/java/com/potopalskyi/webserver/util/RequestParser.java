package com.potopalskyi.webserver.util;

import com.potopalskyi.webserver.common.Constant;
import com.potopalskyi.webserver.dto.HttpMethod;
import com.potopalskyi.webserver.dto.Request;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestParser {

    public static Request parseRequest(BufferedReader bufferedReader) throws IOException {
        Request request = new Request();
        String line = bufferedReader.readLine();
        String[] array = line.split(Constant.SPACE);

        System.out.println("Request : " + line);
        request.setMethod(HttpMethod.getByValue(array[0]));
        request.setUrl(array[1]);

        System.out.println("Params : ");
        while (!(line = bufferedReader.readLine()).isEmpty()) {
            int keyEndIndex = line.indexOf(Constant.COLON);
            String key = getValue(line, 0, keyEndIndex);
            String value = getValue(line, keyEndIndex + 1, line.length());
            System.out.println("Key: value : " + key + ": " + value);
            request.getHeaders().put(key, value);
        }
        return request;
    }

    private static String getValue(String line, int indexFrom, int indexTo) {
        return line.substring(indexFrom, indexTo).trim();
    }
}
