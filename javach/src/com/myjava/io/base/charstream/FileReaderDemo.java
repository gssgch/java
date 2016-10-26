package com.myjava.io.base.charstream;

import java.io.FileReader;
import java.io.IOException;

// 需求： 读取一个文本文件，将读取到的字符打印到控制台。

public class FileReaderDemo {
    /*
     * 创建读取字符数据的流对象
     * 在读取流对象时，必须要明确被读取的文件，一定要确定该文件是存在的。
     * 用一个读取流关联一个已存在的文件
     *
     */
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("f:\\demo.txt"); //eg:ab

        /*        int ch = 0;
                while ((ch = fr.read()) != -1) { //如果返回-1，文件读完了
                    System.out.println(ch);
                }*/

        /*
         * 使用 read(char[])读取
         *
         */
        char[] buf = new char[3];
        int len = 0;
        while ((len = fr.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        fr.close();
    }
}
