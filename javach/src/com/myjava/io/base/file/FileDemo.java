package com.myjava.io.base.file;

import java.io.File;

public class FileDemo {

    public static void main(String[] args) {
        constructorDemo();
    }

    @SuppressWarnings("unused")
    public static void constructorDemo() {
        // 可以将一个已存在的，或者不存在的文件或者目录封装成file对象

        // File 对象的几个构造方法
        File f1 = new File("f:\\a.txt");

        File f2 = new File("f:\\", "a.txt");

        File f = new File("f:\\");
        File f3 = new File(f, "a.txt");

        File ff = new File("f:\\abc\\a.txt"); // 只能在windows下执行，unix下不识别\\ 只识别 /
        // 通用  File.separator：分隔符
        File f4 = new File("f:" + File.separator + "abc" + File.separator + "a.txt");
        System.out.println(f4);
    }
}
