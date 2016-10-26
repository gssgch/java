package com.myjava.io.base.bytestream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopeMp3Test {

    public static void main(String[] args) throws IOException {
        copy_1();
        copy_2();
        copy_3();
        copy_4();
    }

    // 效率非常底，不使用
    public static void copy_4() throws IOException {

        FileInputStream fis = new FileInputStream("f:\\0.mp3");
        FileOutputStream fos = new FileOutputStream("f:\\1.mp3");
        int ch = 0;
        while ((ch = fis.read()) != -1) {
            fos.write(ch);
        }
        fos.close();
        fis.close();
    }

    // 不建议   操作大文件易内存溢出
    public static void copy_3() throws IOException {
        FileInputStream fis = new FileInputStream("f:\\0.mp3");
        FileOutputStream fos = new FileOutputStream("f:\\1.mp3");
        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        fos.write(buf);
        fos.close();
        fis.close();
    }

    // 建议使用
    public static void copy_2() throws IOException {
        FileInputStream fis = new FileInputStream("f:\\0.mp3");
        BufferedInputStream bufis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("f:\\2.mp3");
        BufferedOutputStream bufos = new BufferedOutputStream(fos);
        //        byte[] buf = new byte[1024];
        int ch = 0;
        while ((ch = bufis.read()) != -1) {
            bufos.write(ch);
        }
        bufos.close();
        bufis.close();
    }

    // 自定义缓冲区 操作大文件时，速度会受到影响
    public static void copy_1() throws IOException {
        FileInputStream fis = new FileInputStream("f:\\0.mp3");
        FileOutputStream fos = new FileOutputStream("f:\\1.mp3");
        byte[] buf = new byte[1024];
        int len = 0;
        // 如果不使用缓冲区，就会一直读 效率太低
        //        while ((len = fis.read()) != -1) {
        while ((len = fis.read(buf)) != -1) {
            fos.write(buf, 0, len);

        }
        fos.close();
        fis.close();
    }

}
