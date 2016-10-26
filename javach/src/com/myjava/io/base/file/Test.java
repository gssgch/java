package com.myjava.io.base.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 获取指定目录下，指定扩展名的文件，包含子目录中的文件
 * 这些文件的绝对路径写入到一个文本文件中
 *
 * 简单说： 就是建立一个指定扩展名的文件的列表
 *
 * 思路
 * 深度遍历
 * 遍历中进行过滤，将符合条件的内容存储到容器中
 * 对容器中的内容进行遍历并将绝对路径写入到文件中
 */
public class Test {

    public static void main(String[] args) {
        File dir = new File("f:\\过关宝典");
        // 过滤器
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        };

        List<File> list = new ArrayList<File>();
        getFiles(dir, filter, list);
        File destFile = new File(dir, "java.txt"); // 在dir目录下的文件
        writer2File(list, destFile);
    }

    /**
     *对指定目录中的内容进行深度遍历，并按照指定过滤器进行过滤
     *将过滤后的内容存储到指定容器List中
     */
    public static void getFiles(File dir, FilenameFilter filter, List<File> list) {

        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getFiles(file, filter, list);
            } else {
                // 对遍历到的文件进行过滤器的过滤，将符合条件的对象存储到list集合中
                if (filter.accept(dir, file.getName())) {
                    list.add(file);
                }
            }
        }
    }

    public static void writer2File(List<File> list, File destFile) {
        BufferedWriter bufw = null;
        try {
            bufw = new BufferedWriter(new FileWriter(destFile));
            for (File file : list) {
                bufw.write(file.getAbsolutePath());
                bufw.newLine();
                bufw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufw != null) {
                try {
                    bufw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
