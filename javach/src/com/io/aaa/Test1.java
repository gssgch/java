package com.io.aaa;

import java.io.File;

public class Test1 {
    //使用File类列出指定位置下的文件及目录信息
    public static void main(String[] args) {

        File file = new File("d:");
        //返回一个指定路径名文件数组
        File[] f1 = file.listFiles(); //调用 File[] listFiles()方法
        for (File f : f1) {
            if (f.isDirectory()) {
                //输出目录信息
                System.out.println("目录名称是：" + f.getName());
            } else {
                //输出文件名称
                System.out.println("文件名称是：" + f.getName() + ",文件路径是：" + f.getPath() + ",文件大小是：" + f.length());
            }
        }

    }

}
