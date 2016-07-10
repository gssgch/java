package com.io.base.file;

import java.io.File;

public class FileListDemo {

    public static void main(String[] args) {
        //        listDemo();
        //        listDemo_2();
        listDemo_3();
    }

    public static void listDemo_3() {
        File dir = new File("f:\\");
        File[] files = dir.listFiles(new FilterByHidden());
        for (File file : files) {
            System.out.println(file);
        }

    }

    public static void listDemo_2() {
        /*
         * 逻辑：先找到盘符下的所有文件，通过过滤器，满足条件的放入数组
         */
        File dir = new File("f:\\");
        // 过滤文件名
        //        String[] names = dir.list(new FilterByJava());
        String[] names = dir.list(new SuffixFilter(".java")); // 可修改文件的后缀名过滤
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void listDemo() {
        File file = new File("e:\\");
        /*
         * 获取当前目录下的文件及文件夹的名称，包含隐藏文件
         * 调用list方法的File对象中封装的必须是目录
         * 否则会发生空指针异常
         * 如果访问的是系统目录，也会发生空指针异常
         *
         * 如果目录存在，但是没有内容，会返回一个数组，但是长度为0
         */
        String[] names = file.list();
        System.out.println(names.length);

        for (String name : names) {
            System.out.println(name);
        }
    }
}
