package com.io.base.file;

import java.io.File;

/*
 * 删除一个带内容的目录。
 * 原理：必须从最里面开始删除
 */
public class RemoveDirTest {

    public static void main(String[] args) {
        File dir = new File("f:\\testDir");
        removeDir(dir);
    }

    public static void removeDir(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                removeDir(file);
            } else {
                System.out.println(file + ":" + file.delete());
            }
        }
        System.out.println(dir + ":" + dir.delete());
    }
}
