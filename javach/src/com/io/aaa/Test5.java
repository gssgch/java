package com.io.aaa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Test5 {
    //使用字符流实现文件复制，仅仅复制每行的字符个数小于等于6的，即读取文件中单行长度<=6的
    public static void main(String[] args) {

        try {
            File file = new File("d:/a.txt");
            FileReader fReader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(fReader);
            FileWriter fWriter = new FileWriter("e:\\a.txt");
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            //一行一行的读写
            //先读第一行
            String line = bReader.readLine();
            while (line != null) {
                if (line.length() <= 6) {
                    bWriter.write(line);
                    bWriter.newLine();//换行
                }
                line = bReader.readLine();
            }
            //一次性读写完毕
            //char[] con=new char[(int)file.length()];
            //bReader.read();
            //bWriter.write(con);
            bReader.close();
            fReader.close();
            bWriter.close();
            fWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
