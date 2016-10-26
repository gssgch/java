package com.myjava.regex.reg;

import java.util.regex.Pattern;

public class RegexDemo2 {

    public static void main(String[] args) {
        /*
         * 正则表达式对字符串的常见操作：
         * 1，匹配：
         *      其实就是使用String 的matches方法
         * 2，切割：
         *  其实使用的就是String类中的split方法
         * 3，替换：
         *  其实使用的就是String类中的replaceAll()方法
         *
         * 4，获取：
         *  将正则规则进行对象的封装。
         *  Pattern p=Pattern.compile("a*b");
         *  // 通过正则对象的matcher方法与字符串相关联。获取要对字符串操作的匹配器对象Matcher.
         *  Matcher m=p.matcher("aaaab");
         *   // 通过Matcher匹配器对象的方法对字符串进行操作
         *   boolean b=m.matches();
         *
         */
        //        functionDemo_2();
        //        functionDemo_3();
        functionDemo_4();
    }

    // 获取
    public static void functionDemo_4() {
        String str = "da jia hao,ming tian bu fang jia!";
        String regex = "\\b[a-z]{3}\\b"; // 加上\\b表示左右有边界

        // 1将正则封装成对象
        Pattern p = Pattern.compile(regex);
        // 2，通过正则对象获取匹配器对象
        java.util.regex.Matcher m = p.matcher(str);
        // 3,使用Matcher对象的方法对字符串进行操作
        // 获取之前需要先查找
        while (m.find()) {
            System.out.println(m.group());// 获取匹配的子序列
        }
    }

    // 替换
    public static void functionDemo_3() {
        String str = "zhsantttttlisimmmmmmwwu";
        str = str.replaceAll("(.)\\1+", "$1");
        // 解释：  第一组  一次或多次匹配      $1: 用第一组替换
        System.out.println(str);

        String tel = "15812120011"; // 158****0011
        tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.println(tel);
    }

    /*
     * 切割
     * 组：((a)(b(c)))  从左边括号开始数，分组   一共4个组
     */
    public static void functionDemo_2() {
        //        String str = "zhangs    lis   wz";
        //        String[] names = str.split(" +");

        //        String str = "zhangs.lis.wz";
        //        String[] names = str.split("\\."); // 反斜杠反斜杠点，对\.转义，取消了点的特殊含义，输出点

        String str = "zhangstttttlisaaaaawz";
        // 与第一组相同，匹配多次
        String[] names = str.split("(.)\\1+"); //
        for (String name : names) {
            System.out.println(name);
        }
    }

    // 匹配
    public static void functionDemo_1() {

        // 匹配手机号码是否正确
        String tel = "15800000000";
        String regex = "1[358]\\d{9}";
        // "\\d" :再添加一个反斜杠，对\d进行转义     [358] 匹配358中的任意一个
        boolean b = tel.matches(regex);
        System.out.println(tel + ":" + b);
    }

}
