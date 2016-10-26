package com.myjava.io.base.spitfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

public class MergeFile {

    public static void main(String[] args) throws Exception {
        File dir = new File("f:\\partfiles");
        //        mergeFile(dir);
        mergeFile_2(dir);
    }

    public static void mergeFile_2(File dir) throws Exception {

        // 获取指定目录下的配置文件对象
        File[] files = dir.listFiles(new SuffixFilter(".properties"));
        if (files.length != 1) {
            throw new RuntimeException(dir + ",该目录下无properties扩展名文件，或者不唯一");
        }
        // 获取配置文件对象
        File confile = files[0];

        // 获取该文件中的信息
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(confile);
        prop.load(fis);
        String filename = prop.getProperty("filename");
        int count = Integer.parseInt(prop.getProperty("partcount"));

        // 获取该目录下的所有碎片文件
        File[] partFiles = dir.listFiles(new SuffixFilter(".part"));
        if (partFiles.length != (count - 1)) {
            throw new RuntimeException("碎片文件不符合要求，个数不对，应为" + count + "个");

        }
        // 将碎片文件和流对象关联并储存到集合中
        ArrayList<FileInputStream> a1 = new ArrayList<FileInputStream>();
        for (int x = 0; x < partFiles.length; x++) {
            a1.add(new FileInputStream(partFiles[x]));
        }
        // 将多个流合并为一个序列流
        Enumeration<FileInputStream> en = Collections.enumeration(a1);
        SequenceInputStream sis = new SequenceInputStream(en);
        FileOutputStream fos = new FileOutputStream(new File(dir, filename));
        byte[] buf = new byte[1024];

        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fos.close();
        sis.close();
    }

    public static void mergeFile(File dir) throws IOException {
        ArrayList<FileInputStream> a1 = new ArrayList<FileInputStream>();
        for (int x = 1; x <= 3; x++) {
            a1.add(new FileInputStream(new File(dir, x + ".part")));
        }
        Enumeration<FileInputStream> en = Collections.enumeration(a1);
        SequenceInputStream sis = new SequenceInputStream(en);
        FileOutputStream fos = new FileOutputStream(new File(dir, "2.jpg"));
        byte[] buf = new byte[1024];

        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fos.close();
        sis.close();
    }
}
