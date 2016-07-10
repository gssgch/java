package com.baodian.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

//
public class Test09 {

    public static void main(String[] args) {
        javaHome();//»ñÈ¡»·¾³±äÁ¿
    }

    public static void test() {
        int index;
        String[] test = new String[3];
        //        String f=test[index];//index±ØÐë³õÊ¼»¯
        //        System.out.println(f);
    }

    public static void javaHome()

    {

        Map m = System.getenv();

        for (Iterator it = m.keySet().iterator(); it.hasNext();)

        {

            String key = (String) it.next();

            String value = (String) m.get(key);

            System.out.println(key + ":" + value);

        }

        System.out.println("--------------------------------------");

        Properties p = System.getProperties();

        for (Iterator it = p.keySet().iterator(); it.hasNext();)

        {

            String key = (String) it.next();

            String value = (String) p.get(key);

            System.out.println(key + ":" + value);

        }

    }

}
