package com.potopalskyi.util;

import com.potopalskyi.common.Constant;

import java.io.*;

public class ResourceReader {

    private String pathToResource;

    public BufferedReader getResourse(String url) throws FileNotFoundException {
        String filePath = pathToResource.concat(Constant.BACKSLASH).concat(url);

        String content = Constant.EMPTY;
        try(FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)){

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                content = content.concat(sCurrentLine).concat("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = new ByteArrayInputStream(content.getBytes());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        System.out.println(content);
        return bufferedReader;
    }

    public String getPathToResource() {
        return pathToResource;
    }

    public void setPathToResource(String pathToResource) {
        this.pathToResource = pathToResource;
    }
}
