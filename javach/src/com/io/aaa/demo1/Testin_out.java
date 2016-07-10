package com.io.aaa.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Testin_out {
    public static void main(String[] args) throws Exception {

        writeObject();
        readObject();
    }

    //编写序列化的方法
    public static void writeObject() throws Exception {
        //1.使用File类打开一个文件，如果当前文件不存在则创建新文件
        File f1 = new File("d:" + File.separator + "stuInfo.txt");
        //2.实例化io类
        FileOutputStream outStream = new FileOutputStream(f1);
        ObjectOutputStream os = new ObjectOutputStream(outStream);
        //创建序列化对象
        Student tom = new Student("toy", 20);
        Grade grade = new Grade(1000, "Qy34");
        tom.setGrade(grade);
        //3 进行写操作
        os.writeObject(tom);
        //4 关闭输出流
        outStream.close();
        os.close();
    }

    //反序列化
    public static void readObject() throws Exception {
        File f2 = new File("d:" + File.separator + "stuInfo.txt");
        InputStream inStream = new FileInputStream(f2);
        //创建ObjectInputStream对象
        ObjectInputStream in = new ObjectInputStream(inStream);
        Object object = in.readObject();
        //强转
        Student stu = (Student) object;
        System.out.println("姓名：" + stu.getName());
        System.out.println("年龄：" + stu.getAge());
        System.out.println("班级：" + stu.getGrade().getName());
        inStream.close();
        in.close();

    }

}
