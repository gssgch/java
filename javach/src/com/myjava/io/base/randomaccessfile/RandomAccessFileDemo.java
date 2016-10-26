package com.myjava.io.base.randomaccessfile;

import java.io.IOException;
import java.io.RandomAccessFile;

/* RandomAccessFil   不是io体系中的子类
 *
 * 特点：
 * 1，该对象既能读，又能写
 * 2，该对象内部维护了一个byte数组，并通过指针可以操作数中的元素
 * 3，可以通过getFilePointer方法获取指针的位置，和通过seek方法设置指针的位置
 * 4，其实该对象就是将字节输入流和输出流进行了封装
 * 5，该对象的源或者目的只能是文件，通过构造函数可以看出
 *
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) throws IOException {
        //        writerFile();
        //        readFile();
        reandmoWrite();
    }

    public static void reandmoWrite() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("f:\\acc.txt", "rw");
        // 往指定位置写入数据
        raf.seek(3 * 8);
        raf.write("赵六".getBytes());
        raf.writeInt(117);
        raf.close();
    }

    public static void readFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("f:\\acc.txt", "r"); // r:模式：只读
        // 通过seek设置指针的位置
        //        raf.seek(1 * 8); // 随机的读取，只要指定指针的位置即可

        byte[] buf = new byte[4];
        raf.read(buf);
        String name = new String(buf);
        int age = raf.readInt();
        System.out.println("name:" + name);
        System.out.println("age:" + age);
        System.out.println("point:" + raf.getFilePointer());
        raf.close();
    }

    // 使用randomAccessFile对象写入一些人员信息
    public static void writerFile() throws IOException {
        /*
         * 如果文件不存在，则创建，如果文件存在，不创建
         */
        RandomAccessFile raf = new RandomAccessFile("f:\\acc.txt", "rw");

        raf.write("战三".getBytes());
        raf.writeInt(98);
        raf.write("李四".getBytes());
        raf.writeInt(97);

        raf.close();
    }

}
