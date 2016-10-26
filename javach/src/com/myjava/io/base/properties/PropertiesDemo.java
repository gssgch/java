package com.myjava.io.base.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
 * Map
 *  |--Hashtable
 *     |--Properties:
 *
 * Properties集合：
 * 特点：
 * 1，该集合中的键和值都是字符串类型。
 * 2，集合中的数据可以保持到流中，或者从流中获取。
 *
 * 通常该集合用于操作以键值对形式存在的配置文件。
 */
public class PropertiesDemo {

    public static void main(String[] args) throws IOException {
        //        propertiesDemo();
        //        methodDemo_2();
        //        methodDemo_3();
        //        methodDemo_4();
        //        myLoad();
        methodDemo_5();
    }

    /*
     * 对已有的配置文件的信息进行修改
     *
     * 读取这个文件
     * 并将文件中的键值对数据存储在集合中
     * 再通过集合对数据进行修改
     * 再通过流将修改后的数据存储到文件中
     */
    public static void methodDemo_5() throws IOException {
        File file = new File("f:\\info.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fr = new FileReader("f:\\info.txt");

        // 创建集合存储配置信息
        Properties prop = new Properties();

        // 将流中信息存储到集合中
        prop.load(fr);

        prop.setProperty("ww", "16");

        FileWriter fw = new FileWriter(file);
        prop.store(fw, "");
        prop.list(System.out);
        fw.close();
        fr.close();
    }

    public static void methodDemo_4() throws IOException {
        Properties prop = new Properties();
        /*
         * 集合中的数据来自于一个文件
         * 注意：必须保证该文件中的数据是键值对
         * 需要使用到读取流
         *
         */

        FileInputStream fis = new FileInputStream("f:\\info.txt");
        // 使用load方法
        prop.load(fis);

        prop.list(System.out);
    }

    // 模拟load方法，
    public static void myLoad() throws IOException {
        Properties prop = new Properties();
        BufferedReader buf = new BufferedReader(new FileReader("f:\\info.txt"));
        String line = null;
        while ((line = buf.readLine()) != null) {
            if (line.startsWith("#")) {
                continue;
            }
            String[] arr = line.split("=");
            prop.setProperty(arr[0], arr[1]);
        }
        prop.list(System.out);
        buf.close();

    }

    public static void methodDemo_3() throws IOException {
        Properties prop = new Properties();

        prop.setProperty("zs", "16");
        prop.setProperty("ls", "15");
        prop.setProperty("ww", "14");
        prop.setProperty("zl", "34");

        // 想要将这些集合中的字符串键值信息持久化到存储文件中
        // 需要关联输出流
        FileOutputStream fos = new FileOutputStream("f:\\info.txt");
        // 将集合中的数据存储到文件中，使用store方法
        prop.store(fos, "info"); // 该流是使用iso-8859-1写入的，中文支持不好
        fos.close();
    }

    public static void propertiesDemo() {
        // 创建一个properties集合
        Properties prop = new Properties();

        prop.setProperty("zs", "16");
        prop.setProperty("ls", "15");
        prop.setProperty("ww", "14");
        prop.setProperty("zl", "34");

        // 修改元素
        prop.setProperty("ww", "25");
        // 获取所有元素
        Set<String> names = prop.stringPropertyNames();

        for (String name : names) {
            String value = prop.getProperty(name);
            System.out.println(name + ":" + value);

        }
    }

    /*
     * 演示properties集合和流相结合的功能
     */
    public static void methodDemo_2() {

        Properties prop = new Properties();

        prop.setProperty("zs", "16");
        prop.setProperty("ls", "15");
        prop.setProperty("ww", "14");
        prop.setProperty("zl", "34");

        prop = System.getProperties();
        prop.list(System.out);
    }
}
