package com.myjava.io.base.bytestream;

import java.io.IOException;
import java.io.InputStream;

/*
 * 需求：读取一个键盘录入的数据，并打印在控制台上，
 * 键盘本身就是一个标准的输入设备
 * 对于java而言， 对于这种输入设备都有对应的对象
 */
public class ReadKey {

    public static void main(String[] args) throws IOException {
        //        readKey_1();
        readKey_2();
    }

    public static void readKey_1() throws IOException {
        InputStream in = System.in; // 系统流对象，无需关闭，若关闭之后，就不能再次获取了
        int ch = in.read(); // 阻塞式方法。
        System.out.print(ch);
    }

    public static void readKey_2() throws IOException {
        /*
         * 获取用户键盘录入的数据
         * 并将数据变成大写显示在控制台上
         * 如果用户输入的是over,结束键盘录入
         *
         * 思路：
         * 因为键盘录入只读取一个字节，要判断是否是over,
         * 需要先将读到的字节拼成字符串，
         * 那就需要一个容器，StringBuilder
         * 在用户回车之前将录入的数据变成字符串判断即可
         */
        // 1 创建容器
        StringBuilder sb = new StringBuilder();
        // 2,获取键盘读入
        InputStream in = System.in;

        // 定义变量记录读取到的字节，并循环获取
        int ch = 0;
        while ((ch = in.read()) != -1) {
            // 存储之前需要判断是否是换行标记，换行标记不存储
            if (ch == '\r') {
                continue;
            }
            if (ch == '\n') {
                String temp = sb.toString();
                if ("over".equals(temp)) {
                    break;
                }
                System.out.println(temp.toUpperCase());
                sb.delete(0, sb.length()); // 如果不清缓存，会累加
            } else {

                sb.append((char) ch);
            }
        }
        System.out.println(ch);
    }

}
