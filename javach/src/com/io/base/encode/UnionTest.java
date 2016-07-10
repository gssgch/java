package com.io.base.encode;

import java.io.IOException;

// 在记事本里输入联通两个字，出现乱码

public class UnionTest {

    public static void main(String[] args) throws IOException {
        String str = "联通";
        byte[] buf = str.getBytes("gbk");
        for (byte b : buf) {
            System.out.println(Integer.toBinaryString(b & 255));
        }
    }

}
