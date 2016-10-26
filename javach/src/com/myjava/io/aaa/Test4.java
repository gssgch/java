package com.myjava.io.aaa;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

//编写一个端点续传程序，每次复制文件后，记录当次复制文件结束时的文件的字节数，
//下次复制文件时，在上一次所复制文件的基础上继续进行复制，直到文件复制结束

public class Test4 {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        File f = new File("e:\\new.txt");
        try {
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            //复制
            FileInputStream fis = new FileInputStream("e://old.txt");
            //读取
            File tempFile = new File("e:temp.txt");
            RandomAccessFile raf_temp = null;
            int firstSize = 4;
            byte[] b = new byte[firstSize];
            if (!tempFile.exists()) {
                //如果文件不存在，自动创建，第一次复制，
                raf_temp = new RandomAccessFile(tempFile, "rw");
                fis.read(b, 0, b.length);//读取文件
                raf.write(b, 0, b.length);//写文件
                //向临时文件写入第一次复制的字节数
                raf_temp.seek(0);
                raf_temp.writeInt(firstSize);
            } else {
                //第二次复制
                System.out.println("第二次复制");
                raf_temp = new RandomAccessFile(tempFile, "rw");
                raf_temp.seek(0);
                System.out.println("new size====" + raf_temp.readInt());
                raf.seek(firstSize);//移动指针位置
                fis.skip(firstSize);//读取文件跳过4个字节
                b = new byte[fis.available()];//以剩下的文件大小创建字节数组
                fis.read(b, 0, fis.available());//读取文件
                raf.write(b, 0, b.length);
            }
            raf.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
