package com.myjava.io.base.bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
    public static void main(String[] args) throws IOException {
        //        demo_write();
        //        demo_read();
    }

    public static void demo_read() throws IOException {
        // 创建一个读取流对象，和指定文件关联
        FileInputStream fis = new FileInputStream("f:\\a.txt");

        // 定义一个长度为文件大小的数组，就可以直接读取了
        byte[] buf = new byte[fis.available()]; // 数组长度即为文件大小
        fis.read(buf);
        System.out.println(new String(buf));

        /*// 定义一个缓冲区读取
         * byte[] buf = new byte[1024];
         int len = 0;
         while ((len = fis.read(buf)) != -1) {
             System.out.println(new String(buf, 0, len));
         }*/

        /*// 读取全部字节
        int len = 0;
        while ((len = fis.read()) != -1) {
            System.out.print((char) len);
        }*/

        /* // 一次读取一个字节
         int len = fis.read();
         System.out.println(len);*/

        fis.close();
    }

    public static void demo_write() throws IOException {
        // 创建字节输出流对象，用于操作文件
        FileOutputStream fos = new FileOutputStream("f:\\a.txt");
        // 写数据，直接写入到目的地中
        fos.write("abcds".getBytes());
        fos.close(); // 没有缓冲，没有刷新方法
    }
}
