package com.io.base.charstream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

    private static String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) {

        /* 创建一个可以往文件中写入字符数据的字符流输出对象。
         *
         * 既然是往一个文件中写入文字数据，那么在创建对象时，就必须明确该文件（用于存储数据的目的地）
         * 文件不存在，自动创建；存在，则覆盖
         *
         * 如果构造函数中加入true,可以实现对文件进行续写
         *
         * 调用Writer对象中的writer(String)方法，写入数据
         * 实际是将数据写入到临时缓冲区中
         *
         * 进行刷新，将数据直接写到目的地中
         * fw.flush(); // 可用多次
         *
         *  关闭流，关闭资源。在关闭前会调用flush刷新缓冲区中的数据到目的地
         *  fw.close(); // 只能用一次
         */

        FileWriter fw = null;
        try {
            fw = new FileWriter("f:\\demo111.txt", true);
            //        fw.write("aaa\r\nddd");  // windows下换行用的是\r,而不是\n 记事本编辑器可能不识别\n

            fw.write("aaa" + LINE_SEPARATOR + "aanddd"); // 在各种系统下都能实现换行

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (fw != null) { // 必须进行非空判断，否则如果文件创建失败，会报空指针错误
                try {
                    fw.close();
                } catch (Exception e) {
                    System.out.println("关闭流失败");
                }
            }
        }
    }

}
