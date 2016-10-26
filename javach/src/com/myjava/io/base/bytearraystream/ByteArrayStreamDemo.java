package com.myjava.io.base.bytearraystream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {

    // 源和目的都是内存
    public static void main(String[] args) {

        ByteArrayInputStream bis = new ByteArrayInputStream("abcdef".getBytes());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int ch = 0;
        while ((ch = bis.read()) != -1) {
            bos.write(ch);
        }
        System.out.println(bos.toString());
    }

}
