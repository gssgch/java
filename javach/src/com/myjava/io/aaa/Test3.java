package com.myjava.io.aaa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test3 {

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要复制的文件：");
        String fileName = sc.next();
        File srcfile = new File(fileName);
        System.out.println("请选择文件复制的目标位置：");
        String desFilePath = sc.next();
        FileInputStream fin = null;
        FileOutputStream fos = null;
        try {
            fin = new FileInputStream(srcfile);
            fos = new FileOutputStream(desFilePath + File.separator + srcfile.getName());
            int len = 0;
            while ((len = fin.read()) != -1) {
                fos.write(len);
            }
            System.out.println("复制完成");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("复制失败");
        } finally {
            try {
                fin.close();//关闭流
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
