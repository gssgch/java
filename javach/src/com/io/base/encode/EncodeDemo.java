package com.io.base.encode;

import java.io.IOException;

public class EncodeDemo {

    /*字符串      --》  字节数组：编码。
     * 字节数组--》 字符组：解码。
     *
     */
    public static void main(String[] args) throws IOException {
        /*
         * 你好   ：utf-8 : -28 -67 -96 -27 -91 -67
         *       GBK: -60 -29 -70 -61
         *
         */

        String str = "你好";
        //编码：
        byte[] buf = str.getBytes("GBK");
        printBytes(buf);
        // 解码：
        String s1 = new String(buf, "GBK");
        System.out.println("s1=" + s1);

        //        testiso(); // iso8859-1
        //        testutf(); //utf-8

    }

    // 编对了，解错了，用utf-8就没得救了
    // 原因：使用utf-8解码时，找不到匹配时，就使用未知字符来表示，对应的编码是-17 -65 -67
    public static void testutf() throws IOException {
        //        String str = "你好";
        String str = "哈哈";
        //        String str = "谢谢";
        //编码：
        byte[] buf = str.getBytes("GBK");
        String s2 = new String(buf, "UTF-8");
        System.out.println("s2:" + s2);

        byte[] buf2 = s2.getBytes("UTF-8"); // 获取源字节
        printBytes(buf2);
        /*
         * 你好：-17 -65 -67 -17 -65 -67 -17 -65 -67
         * 哈哈：-17 -65 -67 -17 -65 -67 -17 -65 -67 -17 -65 -67
         * 谢谢：-48 -69 -48 -69
         *
         */
        String s3 = new String(buf2, "GBK");
        System.out.println("s3:" + s3);
    }

    // 编对了，解错了，用iso8859-1还有救
    public static void testiso() throws IOException {
        String str = "你好";
        //编码：
        byte[] buf = str.getBytes("GBK");
        // 方法就是：获取源字节，再重新解码
        String s2 = new String(buf, "iso8859-1");
        System.out.println("s2:" + s2);

        byte[] buf2 = s2.getBytes("iso8859-1"); // 获取源字节
        String s3 = new String(buf2, "GBK");
        System.out.println("s3:" + s3);
    }

    public static void printBytes(byte[] buf) {
        for (byte b : buf) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}
