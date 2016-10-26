package com.myjava.io.base.charstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("f:\\demo.txt");
        /*
         * 为了提高写入的效率，使用了字符流的缓冲区
         * 创建了一个字符写入流的缓冲区对象，并和指定要被缓冲的对象相关联
         */
        BufferedWriter bufw = new BufferedWriter(fw);
        //使用缓冲区的写入方法将数据写入到缓冲区中
        //        bufw.write("avcd");
        //        bufw.newLine();// 换行
        //        bufw.write("fs");
        for (int i = 0; i <= 4; i++) {
            bufw.write("avcd" + i);
            bufw.newLine();// 换行
        }
        // 使用缓冲区的刷新方法将数据刷新到目的地中
        bufw.flush();

        //关闭缓冲区，其实关闭的就是被缓冲的流对象
        bufw.close();
    }

}
