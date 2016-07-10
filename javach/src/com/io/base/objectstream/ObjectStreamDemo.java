package com.io.base.objectstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeObj();
        readObj();
    }

    public static void readObj() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f:\\obj.object"));
        // 反序列化
        Person p = (Person) ois.readObject();
        System.out.println(p.getAge() + "---" + p.getName());
        ois.close();
    }

    public static void writeObj() throws IOException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\obj.object"));
        // 对象序列化，被序列化的对象必须实现serializable
        oos.writeObject(new Person("zs", 30));
        oos.close();
    }

}
