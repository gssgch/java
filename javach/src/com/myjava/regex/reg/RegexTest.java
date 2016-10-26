package com.myjava.regex.reg;

import java.util.TreeSet;

public class RegexTest {
    /*
     * 正则表达式练习：
     * 1，治疗口吃:我我..我...我要要...要要..要要..学..学..学编..编..编..程
     * 2,ip地址排序
     * 3，对邮件地址校验
     */
    public static void main(String[] args) {
        //        test_1();
        //        test_2();
        test_3();
    }

    // 邮箱校验
    public static void test_3() {
        String mail = "abc@sina.com.cn";
        String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{1,3})+"; // 非精确验证
        //        String regex = "^\\w+([\\-_\\.]?\\w*)*@\\w+(\\.\\w+){1,3}$"; // 非精确验证
        // 更模糊
        //        regex="\\w+@\\w+(\\.\\w+)+"; // 1@1.1 都能匹配
        boolean b = mail.matches(regex);
        System.out.println(mail + ":" + b);
    }

    public static void test_1() {
        String str = "我我..我...我要要...要要..要要..学..学..学编..编..编..程";

        // 将字符串中的..去掉，用替换
        str = str.replaceAll("\\.+", "");
        System.out.println(str);
        // 替换叠词
        str = str.replaceAll("(.)\\1+", "$1");
        System.out.println(str);
    }

    /*
     * ip地址排序：
     * 192.168。10.34 127.0.0.1 3.3.3.3   105.40.11.154
     */
    public static void test_2() {
        String str = "192.168.10.34 127.0.0.1 3.3.3.3   105.40.11.154";
        /*
         * 为了让ip可以按照字符串顺序比较，只要让ip的每一段的位数相同
         * 所以，补零，按照每一位所需做多0补充，每一段都加两个0
         *
         */
        str = str.replaceAll("(\\d+)", "00$1");

        System.out.println(str);
        // 每一段保留数字3位
        str = str.replaceAll("0*(\\d{3})", "$1");
        System.out.println(str);

        // 将ip地址切出
        String[] ips = str.split(" +");
        TreeSet<String> ts = new TreeSet<String>();
        for (String ip : ips) {
            ts.add(ip);
        }
        for (String ip : ts) {
            str = ip.replaceAll("0*(\\d+)", "$1");
            System.out.println(str);
        }
    }
}
