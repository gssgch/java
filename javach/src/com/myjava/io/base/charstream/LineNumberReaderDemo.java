package com.myjava.io.base.charstream;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("f:\\demo.txt");
        LineNumberReader lnr = new LineNumberReader(fr);
        String line = null;
        // 默认行号从1开始
        //        lnr.setLineNumber(100); // 设置起始行号
        while ((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + ":" + line);
        }
        lnr.close();
    }
}
