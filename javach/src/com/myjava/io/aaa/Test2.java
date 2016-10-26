package com.myjava.io.aaa;

import java.io.File;

public class Test2 {
    //使用file类列出指定位置下的文件信息，包含该路径子目录下的文件信息
    public static void main(String[] args) {

        File file = new File("d:");
        search(file);
    }

    public static void search(File file) {

        File[] fi = file.listFiles();
        for (File f2 : fi) {
            //System.out.println(aaa.getPath());
            if (f2.isDirectory()) {
                File[] f3 = f2.listFiles();
                System.out.println("目录名称是：" + f2.getName() + "\n目录下有文件\n");
                for (File f4 : f3) {
                    System.out.println("  " + f4.getName());
                }
                System.out.println("-----");
            } else {
                System.out.println("文件名称：" + f2.getName() + ",文件路径：" + f2.getPath() + ",文件大小：" + f2.length());
            }

        }
    }

}
