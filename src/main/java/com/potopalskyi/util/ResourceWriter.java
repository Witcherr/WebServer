package com.potopalskyi.util;

import com.potopalskyi.common.Constant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ResourceWriter {

    public static void writeResponse(BufferedReader content, BufferedWriter clientWriter) throws IOException {
        String line = Constant.EMPTY;
        String header = Constant.OK_STATUS;
        clientWriter.write(header);
        clientWriter.newLine();
        clientWriter.newLine();

        while(!(line = content.readLine()).isEmpty()){
            clientWriter.write(line);
            clientWriter.flush();
        }
    }
}
