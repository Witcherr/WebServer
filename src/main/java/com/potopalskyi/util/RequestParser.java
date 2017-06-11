package com.potopalskyi.util;

import com.potopalskyi.common.Constant;
import com.potopalskyi.dto.HttpMethod;
import com.potopalskyi.dto.Request;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestParser {

    public static Request parseRequest(BufferedReader bufferedReader) throws IOException {
        Request request = new Request();
        String line = "";

        line = bufferedReader.readLine();
        String[] array = line.split(Constant.SPACE);

        request.setMethod(HttpMethod.getByValue(array[0]));
        request.setUrl(array[1].substring(1));

        while(!(line = bufferedReader.readLine()).isEmpty()){
            String key = line.substring(0, line.indexOf(Constant.COLON));
            String value = line.substring(line.indexOf(Constant.COLON)+1, line.length()).trim();
            request.getHeaders().put(key, value);
        }
        return request;
    }

}
