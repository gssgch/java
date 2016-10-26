package com.myjava.io.base.charstream;

import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReaderDemo {

    /*
     * 自定义的读取缓冲区练习
     */
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("f:\\demo.txt");

        MyBufferedReader bufr = new MyBufferedReader(fr);
        String line = null;
        while ((line = bufr.myReadLine()) != null) {
            System.out.println(line);
        }
        bufr.close();
    }
}
