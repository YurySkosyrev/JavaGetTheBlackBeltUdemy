package com.javacourse.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) throws IOException {

        FileReader reader = null;

        try {
            reader = new FileReader("text1");
            int character;
            while ((character=reader.read())!=-1){
                System.out.print((char)character);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            reader.close();
        }

        System.out.println("Done");
    }
}
