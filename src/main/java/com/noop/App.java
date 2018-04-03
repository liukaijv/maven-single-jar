package com.noop;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        try {

            String filePath = "config/app.json";
            String fileContent = fileToString(filePath);

            String[] contents = (new Gson()).fromJson(fileContent, String[].class);

            System.out.println(Arrays.stream(contents).collect(Collectors.joining(" ")));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String fileToString(String path) throws IOException {

        File file = new File(path);
        if (file.exists()) {
            return FileUtils.readFileToString(file, "UTF-8");
        } else {
            InputStream inputStream = App.class.getClassLoader().getResourceAsStream(path);
            return new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining(System.lineSeparator()));
        }

    }
}
