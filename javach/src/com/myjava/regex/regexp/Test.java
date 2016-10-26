package com.myjava.regex.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        //        test1();
        //        test2();
        //        test3();
        //        test4();
        test5();
        //        test6();
        //        test7();
        //        test8();
        //        test9();
        //        test10();
    }

    // group
    public static void test9() {
        Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");
        String s = "123aa-34345bb-234cc-00";
        Matcher m = p.matcher(s);
        while (m.find()) {
            p(m.group() + "--" + m.group(1) + "--" + m.group(2));
        }
    }

    // replacement
    public static void test8() {
        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE); // 忽略大小写
        Matcher m = p.matcher("java Java JaVa I love Java fgsdgwt");
        //        p(m.replaceAll("JAVA"));

        StringBuffer buf = new StringBuffer();
        int i = 0;
        while (m.find()) {
            i++;
            if ((i % 2) == 0) {
                m.appendReplacement(buf, "java");
            } else {
                m.appendReplacement(buf, "JAVA");
            }
        }
        m.appendTail(buf); // 添加结尾
        p(buf);
    }

    // start and end
    public static void test7() {
        Pattern p = Pattern.compile("\\d{3,5}");
        String s = "123-3456-242-03";
        Matcher m = p.matcher(s);
        p(m.matches());
        m.reset(); // 从头开始匹配
        p(m.find());
        p(m.start() + "-" + m.end()); // 开始和起始位置
        p(m.find());
        p(m.start() + "-" + m.end());
        p(m.find());
        p(m.start() + "-" + m.end());
        p(m.find());

    }

    // matches find lookingAt
    public static void test6() {
        Pattern p = Pattern.compile("\\d{3,5}");
        String s = "123-3456-242-03";
        Matcher m = p.matcher(s);
        // matches 与 find 一起使用 会有一些影响
        p(m.matches()); // 匹配整个字符串
        /*
         * matches()匹配到第四个字符时，匹配不上，返回false,接着find()的时候
         * 是从第5个字符开始匹配的，所以当有m.matches()时，find的结果不一样
         * 为了避免这种情况出现，可以使用reset(),从新开始匹配
         */
        m.reset();
        p(m.find()); // 找子串
        p(m.find());
        p(m.find());
        p(m.find());

        p(m.lookingAt()); // 每一次查找都是从头开始查找
        p(m.lookingAt());
        p(m.lookingAt());
        p(m.lookingAt());
    }

    // boundary
    public static void test5() {
        p("hello sir".matches("^h.*"));
        p("hello sir".matches(".*ir$"));
        p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
        p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));

        // whilte lines
        p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));

        p("aaa 8888c".matches(".*\\d{4}.*"));
        p("aaa 8888c".matches(".*\\b\\d{4}.*"));
        p("aaa8888c".matches(".*\\d{4}.*"));
        p("aaa8888c".matches(".*\\b\\d{4}.*"));
    }

    // 认识 \s \d \w
    public static void test4() {
        p(" \n\r\t".matches("\\s{4}"));
        p(" ".matches("\\S"));
        p("a_8".matches("\\w{3}"));
        p("abc888&^%".matches("[a-z]{1,3}\\d+[&^%$]+"));
        p("\\".matches("\\\\")); // 正则表达式里匹配一个反斜线

    }

    // 范围
    public static void test3() {
        p("a".matches("[abc]")); // 匹配一个
        p("a".matches("[^abc]")); //  匹配除abc的一个字符
        p("A".matches("[a-zA-Z]")); //  大写字母或小写字母
        p("A".matches("[a-z]|[A-Z]")); //
        p("A".matches("[a-z[A-Z]]")); //
        p("R".matches("[A-Z&&[RFG]]")); // 交集

    }

    // 初步认识. * + ?
    /*  *:0个或多个     +:一个或多个    ?: 0个或一个    .:匹配任意
     * 如果要匹配. 需要转移\.  在java中是\\.
     *
     */
    @SuppressWarnings("unused")
    private static void test2() {
        p("a".matches("."));
        p("aa".matches("aa"));
        p("aaaa".matches("a*")); //
        p("aaaa".matches("a+")); //
        p("aaaa".matches("a?")); //
        p("".matches("a*"));
        p("".matches("a?"));
        p("a".matches("a?"));
        p("12215456547657".matches("\\d{3,100}"));
        p("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
        p("192".matches("[0-2][0-9][0-9]"));
    }

    // 简单认识正则表达式的概念
    public static void test1() {
        p("abc".matches("...")); // .表示任意一个字符
        p("ac1234f".replaceAll("\\d", "-"));
        Pattern p = Pattern.compile("[a-z]{3}");
        Matcher m = p.matcher("avs");
        p(m.matches());

        p("sac".matches("[a-z]{3}"));
    }

    public static void test10() {
        // Greedy qulifiers  贪婪的
        // reluctant qulifiers  勉强的，不情愿的
        // possessive qulifiers  独占的
        Pattern p = Pattern.compile("(.{3,10})[0-9]");
        // 吃最多的，先吞10个字符，然后匹配整个正则表达式，不匹配，再吐一个，可以匹配上了 ，就结束了

        //        Pattern p = Pattern.compile("(.{3,10}?)[0-9]"); // 勉强的，不情愿的
        // 吃最少的，先吞3个，再匹配正则，不匹配，接着吃，到第五个，匹配上了，结束

        //        Pattern p = Pattern.compile("(.{3,10}+)[0-9]"); // 独占的
        // 直接匹配最多的，吞10个， 也不往外吐，不能匹配上，就退出报错了    再字符串后再加一个数就能匹配了
        //        String s = "aaaa5bbbb68";

        String s = "aaaa5bbbb6";
        Matcher m = p.matcher(s);
        if (m.find()) {
            p(m.start() + "-" + m.end());
        } else {
            p("not match!");
        }

        p("----------------");

        //non-capturing groups   非捕获组
        Pattern p2 = Pattern.compile(".{3}(?=a)"); // 抓3个任意字符，且以a结束，不捕获a  (?=a):以a做为结束
        //        Pattern p2 = Pattern.compile("(?=a).{3}"); // 以a打头，捕获3个字符
        //        Pattern p2 = Pattern.compile("(?!a).{3}"); // 开头不能是a，捕获3个字符
        //        Pattern p2 = Pattern.compile(".{3}(?!a)"); // 捕获3个字符，且后面不是a，
        //        Pattern p2 = Pattern.compile(".{3}(?<!a)"); // 从后往前数，不是a
        //        Pattern p2 = Pattern.compile(".{3}(?<=a)"); // 从后往前数，里面包含a
        String s2 = "444a66b";
        Matcher m2 = p2.matcher(s2);
        while (m2.find()) {
            p(m2.group());
        }

        p("----------------");

        //back refenrences   向前引用
        Pattern p3 = Pattern.compile("(\\d\\d)\\1"); // 1 第一组代表的字符串    后面找的要和第一个组捕捉的一样
        //        Pattern p3 = Pattern.compile("(\\d(\\d))\\2"); // 2 第二个组代表的字符串
        //        String s3 = "122";
        String s3 = "1212";
        Matcher m3 = p3.matcher(s3);
        p(m3.matches());

        p("----------------");
        //flags的简写
        Pattern p4 = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        p("Java".matches("(?i)(java)")); // 上面这种方式的简写
    }

    public static void p(Object o) {
        System.out.println(o);
    }

}
