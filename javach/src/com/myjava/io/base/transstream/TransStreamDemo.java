package com.myjava.io.base.transstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/*
 * 键盘录入
 */
public class TransStreamDemo {

    public static void main(String[] args) throws IOException {

    }

    // 原始的方法
    public static void transStream_1() throws IOException {
        // 字节流
        InputStream in = System.in;
        // 将字节转换为字符的桥梁，转换流
        InputStreamReader isr = new InputStreamReader(in);
        // 字符流
        BufferedReader bufr = new BufferedReader(isr);

        OutputStream out = System.out;
        OutputStreamWriter osw = new OutputStreamWriter(out);

        BufferedWriter bufw = new BufferedWriter(osw);
        String line = null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            //            System.out.println(line.toUpperCase() );
            //            out.write(line.toUpperCase()+"\r\n");
            //            osw.flush();
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }

    }

    // 简化后的代码
    public static void transStream_2() throws IOException {

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }

    }

    public static void transStream_3() throws IOException {
        /*
         *  需求：将键盘录入的数据写入到文件中
         */
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("f:\\a.txt")));
        String line = null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }
        bufw.close();
    }

    @SuppressWarnings("resource")
    public static void transStream_4() throws IOException {
        /*
         *  需求：将文件中数据输出到控制台
         */
        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("f:\\ab.txt")));

        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }

    }

    @SuppressWarnings("resource")
    public static void transStream_5() throws IOException {
        /*
         *  需求：将一个文件中的内容复制到另一个文件中
         */
        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("f:\\sa.txt")));

        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("f:\\a.txt")));
        String line = null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }

    }

}
