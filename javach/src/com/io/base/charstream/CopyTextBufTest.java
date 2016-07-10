package com.io.base.charstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 实现文本文件的复制
/*
 * 读取流，写入目的地，使用字符流
 */
public class CopyTextBufTest {

    private static int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        //        copyText1(); // read();
        copyText2();
    }

    public static void copyText1() throws IOException {
        // 读取一个已有的文本文件，使用字符读取流和文件相关联
        FileReader fr = new FileReader("f:\\demo.txt");
        BufferedReader bufr = new BufferedReader(fr);

        // 创建一个目的地，用于存储读到的数据
        FileWriter fw = new FileWriter("f:\\democopy.txt");
        BufferedWriter bufw = new BufferedWriter(fw);

        /*       int ch = 0;
               while ((ch = bufr.read()) != -1) {
                   bufw.write(ch);
               }*/
        String line = null;
        while ((line = bufr.readLine()) != null) {
            bufw.write(line);
            bufw.newLine();// 换行，按行读取
            bufw.flush();
        }
        // 关闭流
        bufw.close();
        bufr.close();
    }

    public static void copyText2() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("f:\\demo.txt");
            fw = new FileWriter("f:\\demotext.txt");
            // 创建一个临时容器，用于缓存读取的字符
            char[] buf = new char[BUFFER_SIZE];
            // 定义一个变量记录读取到的字符数（往数组里装的字符个数）
            int len = 0;
            while ((len = fr.read(buf)) != -1) {
                fw.write(buf, 0, len);
            }
        } catch (Exception e) {

        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
