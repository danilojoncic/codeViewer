package org.example.util;

import java.io.*;

public class MyFileWriter {
    private static MyFileWriter instance;
    private MyFileWriter(){

    }
    public static boolean writeFile(String fileName, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static MyFileWriter getInstance(){
        if(instance == null){
            instance = new MyFileWriter();
        }
        return instance;
    }
}
