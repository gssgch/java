package com.myjava.io.base.printstream;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

/*
 * PrintStream
 * 提供了打印方法可以对多种数据类型值进行打印，并保持数据的表示形式
 * 不抛IOException
 *
 * 构造函数接收3种类型的值
 * 字符串路径
 * File对象
 * 字节输出流
 *
 *
 * PrintWriter:字符打印流
 * 构造函数参数：
 * 1，字符流路径
 * 2，File对象
 * 3，字节输出流
 * 4，字符输出流
 *
 *
 *
 *
 */
public class PrintDemo {

    public static void main(String[] args) throws IOException {
        printStreamDemo();
        printWriterDemo();
    }

    public static void printStreamDemo() throws IOException {
        PrintStream out = new PrintStream("f:\\print.txt");
        //        out.write(97);  // 只写最低8位
        out.print(97); // 将97先变成字符保持原样，将数据打印到目的地
        out.close();
    }

    public static void printWriterDemo() throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        //        PrintWriter out = new PrintWriter(System.out, true); // 这里加true后，不需要flush刷新
        PrintWriter out = new PrintWriter(new FileWriter("f:\\out.txt"), true); // 将键盘输入内容添加到文件中
        String line = null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            out.println(line.toUpperCase());
            //            out.flush();
        }
        out.close();
    }

}
