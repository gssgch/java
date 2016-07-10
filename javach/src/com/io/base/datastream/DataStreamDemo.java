package com.io.base.datastream;

// 操作基本数据类型的对象
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo {

    public static void main(String[] args) throws IOException {
        writeData();
        readData();
    }

    public static void readData() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("f:\\data.txt"));
        String str = dis.readUTF();
        System.out.println(str);
        dis.close();
    }

    public static void writeData() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("f:\\data.txt"));
        dos.writeUTF("你好!");
        dos.close();
    }
}
