package com.io.aaa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//字符输入输出流练习
public class Test {

    public static void main(String[] args) throws Exception {

        //testWriter();
        //testInputStreamReader();
        //testOutputStreamReader();
        //testBufferedWriter();
        testPrintWriter();
        testPrintWriter2();
    }

    //Filereader和 FileWriter是reader和writer的实现子类，主要用于读写文本文件
    public static void testWriter() throws Exception {
        File file = new File("d:demo.doc");
        FileWriter out = new FileWriter(file);
        out.write("hi");
        out.close();
        FileReader reader = new FileReader(file);
        char[] a = new char[1024];
        int len = reader.read(a);//将内容读取到字符数组中
        System.out.println(new String(a, 0, len));
        reader.close();

    }

    //inputStreamreader和OutputStreamwriter分别为reader和writer类的子类

    //inputStreamreader的构造方法
    //InputStreamReader(InputStream in)//创建使用默认字符集的inputStreamreader
    //InputStreamReader(InputStream in，String charsetName)//创建使用指定字符集的inputStreamreader

    public static void testInputStreamReader() throws Exception {
        File f = new File("d:/demo.doc");
        //创建字节流对象
        FileInputStream fis = new FileInputStream(f);
        //字节流变为字符流
        InputStreamReader reader = new InputStreamReader(fis);
        char[] a = new char[1024];
        int len = reader.read(a);
        System.out.println(new String(a, 0, len));
        reader.close();
    }

    //OutputStreamWriter的构造方法
    //OutputStreamWriter(OutputStream out)  //创建使用默认字符编码的OutputStreamWriter
    //OutputStreamWriter(OutputStream out,String charsetName)  //创建使用指定字符编码的OutputStreamWriter

    public static void testOutputStreamReader() throws Exception {
        File f = new File("d:demo.txt");
        //创建字节流对象
        FileOutputStream fos = new FileOutputStream(f);
        //将字符流变成字节流
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("小玲珑");
        osw.close();
    }

    //bufferedWriter 和 bufferedReader 是带缓冲区的reader和writer
    public static void testBufferedWriter() throws Exception {
        File f = new File("d:aaa.txt");
        FileWriter writer = new FileWriter(f);
        BufferedWriter bufWriter = new BufferedWriter(writer);
        bufWriter.write("东方不败");
        bufWriter.close();
        writer.close();
        FileReader reader = new FileReader(f);
        BufferedReader bufReader = new BufferedReader(reader);
        String content = bufReader.readLine(); //从缓冲区读取数据
        System.out.println(content);
        bufReader.close();
        reader.close();
    }

    //printWriter是writer的子类，作用是将格式化的数据或对象输出到一个文本流
    @SuppressWarnings("resource")
    public static void testPrintWriter() throws Exception {
        //创建不带自动刷新的Printwriter
        PrintWriter pw = new PrintWriter("d:tes.txt");
        pw.println("华山论剑");
        pw.println("java"); // 没有自动刷新，所以程序没有写入文件中
    }

    public static void testPrintWriter2() throws Exception {
        PrintWriter pw = new PrintWriter("d:test.txt");
        //创建带自动刷新的printWriter
        //PrintWriter fw=new PrintWriter("d:test.txt");
        //PrintWriter pw=new PrintWriter(fw,true); //方法一：在创建printWriter对象时开启自动刷新选项
        pw.println("hello hehe");
        pw.println("oop");
        pw.flush();//方法二：调用flush()方法 强制刷新缓冲区
        pw.close();
    }
}
