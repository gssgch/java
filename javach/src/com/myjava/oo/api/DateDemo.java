package com.myjava.oo.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期对象和毫秒值之间的转换
 *
 * 毫秒值--》日期对象
 * 1，通过Date对象的构造方法  new Date(timeMillis);
 * 2,还可以通过setTime设置
 * 因为可以通过Date对象的方法对该日期中的各个字段(年月日等)进行操作
 *
 * 日期对象-->毫秒值
 * getTime()方法
 * 因为可以通过具体的数值进行运算
 *
 * 对日期对象进行格式化
 * 将日期对象-->日期格式的字符串
 * 使用的是DateFormat类中的format方法。
 */
public class DateDemo {

    public static void main(String[] args) throws ParseException {
        //        methodDemo1();
        //        methodDemo2();
        methodDemo_3();
    }

    /**
     * 对日期对象格式化
     */
    public static void methodDemo2() {
        Date date = new Date();
        // 获取日期格式对象   默认风格   Full,LONG等可指定风格。
        DateFormat dateFormat = DateFormat.getInstance();
        dateFormat = DateFormat.getDateTimeInstance();
        dateFormat = DateFormat.getDateInstance(DateFormat.FULL);

        // 自定义日期格式
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = dateFormat.format(date);
        System.out.println(str);
    }

    public static void methodDemo1() {
        long time = System.currentTimeMillis();
        System.out.println(time);
        Date d1 = new Date(); // 将当前日期和时间封装成Date对象
        System.out.println(d1);
        Date d2 = new Date(1405944882336L); // 将指定毫秒值封装成Date对象
        System.out.println(d2);
    }

    /**
     * 将日期格式的字符串-->日期对象
     * 使用的是DateFormat类中的parse()方法
     * 将日期对象-->日期格式的字符串
     * 使用的是DateFormat类中的format方法。
     * @throws ParseException
     */
    public static void methodDemo_3() throws ParseException {
        //        String str = "2014-3-3";
        //        DateFormat dateFormat = DateFormat.getDateInstance();
        String str = "2014年-3月-3日";
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);

        //        String str = "2014---3--3";
        //        dateFormat = new SimpleDateFormat("yyyy---MM--dd");

        Date date = dateFormat.parse(str);
        System.out.println(date);
    }
}
