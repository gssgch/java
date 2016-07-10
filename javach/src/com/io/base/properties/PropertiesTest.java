package com.io.base.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * 定义功能：获取一个应用程序运行的次数，如果超过5次，给出使用的次数已到请注册的提示，并停止运行程序
 *
 * 思路：计数器
 * 每次程序启动需要统计一次，并且在原有基础上计数
 * 计数器就是一个变量，需要存储在硬盘上
 *
 * 使用：
 * 程序启动时，读取用于记录计数器的配置文件，
 *
 * 映射关系map集合搞定，又需要读取硬盘上的数据，
 * 所以map+io =properties
 *
 */
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        getAppCount();
    }

    public static void getAppCount() throws IOException {
        // 将配置文件封装成File对象
        File file = new File("f:\\count.properties");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);

        // 从集合中通过键获取次数
        String value = prop.getProperty("time");
        // 定义计数器，记录已获取的次数
        int count = 0;
        if (value != null) {
            count = Integer.parseInt(value);
            if (count >= 5) {
                System.out.println("使用次数已到上限，请注册");

                throw new RuntimeException();
            }
        }
        count++;
        System.out.println("已使用" + count + "次");
        // 将改变后的次数重新存储到集合中
        prop.setProperty("time", count + "");
        FileOutputStream fos = new FileOutputStream(file);
        prop.store(fos, "");
        ;
        fos.close();
        fis.close();
    }
}
