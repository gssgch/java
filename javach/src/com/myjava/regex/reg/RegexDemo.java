package com.myjava.regex.reg;

/*
 * 正则表达式：
 * 正则表达式用于操作字符串数据
 * 通过一些特定的符号来体现
 * 所以为了掌握正则表达式，必须要掌握一些符号
 *
 */
public class RegexDemo {

    public static void main(String[] args) {
        String qq = "1234533";
        //        checkQQ(qq);
        String regex = "[1-9][0-9]{4,14}"; //正则表达式
        boolean d = qq.matches(regex);
        System.out.println(qq + ":" + d);
    }

    /*
     * 需求：定义一个功能对QQ号进行校验
     * 要求：长度5——15，只能是数字，0不能开头
     */
    public static void checkQQ(String qq) {
        int len = qq.length();
        if ((len >= 5) && (len <= 15)) {
            if (!qq.startsWith("0")) {
                try {

                    Long.parseLong(qq);
                } catch (NumberFormatException e) {
                    System.out.println(qq + "含有非法字符！");
                }
            } else {
                System.out.println(qq + "不能以0开头");
            }
        }
    }
}
