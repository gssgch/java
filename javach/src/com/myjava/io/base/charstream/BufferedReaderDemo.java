package com.myjava.io.base.charstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

    public static void main(String[] args) throws IOException {
        //        bufferedReaderDemo();
    }

    public static void bufferedReaderDemo() throws IOException {
        FileReader fr = new FileReader("f:\\demo.txt");

        BufferedReader bufr = new BufferedReader(fr);
        String line = null;
        while ((line = bufr.readLine()) != null) {
            System.out.println(line);
        }
        bufr.close();
    }
}
