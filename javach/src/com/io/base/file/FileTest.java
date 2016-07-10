package com.io.base.file;

import java.io.File;

/*
 * 需求：对指定目录进行所有内容的列出（包含子目录中的内容）
 * 也可以理解为深度遍历
 */
public class FileTest {

    public static void main(String[] args) {
        File dir = new File("f:\\JAVA图书馆");
        listAll(dir, 0); // 加缩进，从0开始
    }

    public static void listAll(File dir, int level) {
        System.out.println(getSpace(level) + dir.getName());

        //        System.out.println("dir:" + dir.getAbsolutePath()); //  绝对路径
        //        System.out.println("dir:" + dir.getName());
        level++;
        // 获取指定目录下当前的所有文件夹或者文件对象
        File[] files = dir.listFiles();
        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory()) {
                listAll(files[x], level);
            } else {
                //                System.out.println("file:" + files[x].getAbsolutePath());
                //                System.out.println("file:" + files[x].getName());
                System.out.println(getSpace(level) + files[x].getName());
            }
        }
    }

    // 带缩进的输出
    public static String getSpace(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append("|--");
        for (int x = 0; x < level; x++) {
            //            sb.append("   ");
            sb.insert(0, "|  ");
        }
        return sb.toString();
    }

}
