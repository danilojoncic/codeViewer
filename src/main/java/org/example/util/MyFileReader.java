package org.example.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class MyFileReader {
    private static MyFileReader instance;
    private MyFileReader(){

    }
    public static String readFile(String fileName){
        try {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static MyFileReader getInstance(){
        if(instance == null){
            instance = new MyFileReader();
        }
        return instance;
    }
}
