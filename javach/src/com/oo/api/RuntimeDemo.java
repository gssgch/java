package com.oo.api;

public class RuntimeDemo {

    public static void main(String[] args) throws Exception {

        /*
         * Runtime：没有构造方法摘要，说明该类不可以创建对象。
         * 还有静态方法， 说明该类应该提供静态的返回该类对象的方法。
         * 而且只有一个，说明Runtime类使用了单列设计模式。
         */

        Runtime r = Runtime.getRuntime();

        // execute 执行   XXX.exe
        //        r.exec("notepad.exe"); // 打开记事本
        r.exec("notepad.exe F:\\SystemDemo.java"); // 调用  解析

        Process p = r.exec("notepad.exe");
        Thread.sleep(5000);
        p.destroy(); // 只能杀本对象开启的进程
    }

}
