package com.io.base.file;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodDemo {
    /*
     * File对象的常见方法
     * 1，获取
     *  1.1 获取文件名称
     *  1.2 获取文件路径
     *  1.3 获取文件大小
     *  1.4 获取文件修改时间
     *
     * 2,创建与删除
     *  boolean
     *
     * 3,判断
     *
     * 4,重命名
     */
    public static void main(String[] args) throws IOException {
        //        getDemo();
        //        creat_deleteDemo();
        //        isDemo();
        //        renameToDemo();
        listRootsDemo();

    }

    public static void listRootsDemo() {

        File f = new File("f:\\");
        System.out.println("getFreeSpace:" + f.getFreeSpace()); // 空闲大小
        System.out.println("getTotalSpace:" + f.getTotalSpace()); // 总大小
        System.out.println("getUsableSpace:" + f.getUsableSpace()); // 可给虚拟机用的大小

        File[] files = File.listRoots();
        for (File file : files) { // 找出系统中有多少盘符
            System.out.println(file);
        }
    }

    public static void renameToDemo() {
        File f1 = new File("f:\\a.mp3");
        File f2 = new File("f:\\abc.mp3");

        boolean b = f1.renameTo(f2); // 重命名此抽象路径名表示的文件
        System.out.println(b);

    }

    public static void isDemo() {
        File file = new File("f:\\u8_1.txt");
        boolean b = file.exists();
        System.out.println("b:" + b);

        file.mkdir(); // 可以有后缀的文件夹名和无后缀的文件名，所以需要判断是文件还是目录
        // 在判断文件是文件还是目录之前，先判断文件是否存在
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }

    /*
     * 和输出流不一样，如果文件不存在，则创建，如果存在，则不创建
     */
    @SuppressWarnings("unused")
    public static void creat_deleteDemo() throws IOException {

        File dir2 = new File("f:\\abc\\sa\\new\\s");
        boolean b3 = dir2.mkdirs(); // 创建多级目录
        System.out.println(b3);
        // 会删除最后一个目录，即案例中的s,它的父级目录还都在

        File dir = new File("f:\\abc");
        boolean b = dir.mkdir(); // 创建目录

        // windows删除目录从里往外删，目录下有内容目录删除不掉
        // 如果文件正在被流操作，也不能删除掉
        System.out.println(dir.delete());
        // delete方法慎用，删除不走回收站，直接彻底删除

        //        File file = new File("f:\\file.txt");
        //        boolean b = file.createNewFile();
        //        System.out.println("b:" + b);

        //        boolean c = file.delete();
        //        System.out.println("c:" + c);
    }

    @SuppressWarnings("unused")
    public static void getDemo() {
        File file = new File("f:\\a.txt");
        String name = file.getName();
        String path = file.getPath(); // 相对路径
        String absPath = file.getAbsolutePath(); // 绝对路径
        long len = file.length();
        long time = file.lastModified(); //
        Date date = new Date(time);
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String str_time = dateFormat.format(date);

        System.out.println("parent:" + file.getParent());

        System.out.println("name:" + name);
        System.out.println("absPath:" + absPath);
        System.out.println("len:" + len);
        System.out.println("time:" + time);
        System.out.println("str_time:" + str_time);
    }
}
