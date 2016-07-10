package com.io.base.encode;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        String str = "ab你好cd谢谢";

        int len = str.getBytes("gbk").length;
        //        int len = str.getBytes("utf-8").length;
        for (int x = 0; x < len; x++) {
            System.out.println("截取" + (x + 1) + "个字节：" + cutStringByByte(str, x + 1)); //gbk
            //            System.out.println("截取" + (x + 1) + "个字节" + cutStringByU8Byte(str, x + 1));
        }
    }

    // utf-8编码
    public static String cutStringByU8Byte(String str, int len) throws IOException {

        byte[] buf = str.getBytes("utf-8");
        int count = 0;
        for (int x = len - 1; x >= 0; x--) {
            if (buf[x] < 0) {
                count++;
            } else {
                break;
            }
        }
        if ((count % 3) == 0) {
            return new String(buf, 0, len, "utf-8");
        } else if ((count % 3) == 1) {
            return new String(buf, 0, len - 1, "utf-8");
        } else {
            return new String(buf, 0, len - 2, "utf-8");
        }

    }

    /*
     * 在java中，字符串"abcd"和字符串"ab你好"的长度是一样的，都是4个字，
     * 但对应的字节数不一样，一个汉字占两个字符
     * 定义一个方法，按照最大的字节数来读取子串，
     * eg:对于"ab你好"，如果取3个字节，就会去汉字的半个，那么半个就要去掉，如果取4个字节，就是"ab你好"，5个字节还是"ab你好"
     *
     */
    // gbk码
    public static String cutStringByByte(String str, int len) throws IOException {
        byte[] buf = str.getBytes("gbk");
        int count = 0;
        for (int x = len - 1; x >= 0; x--) {
            if (buf[x] < 0) {
                count++;
            } else {
                break;
            }
        }
        if ((count % 2) == 0) {
            return new String(buf, 0, len, "gbk");
        } else {
            return new String(buf, 0, len - 1, "gbk");
        }

    }
}
