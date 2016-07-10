package com.regex.reg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 网页爬虫：其实就是一个程序用于在互联网中获取指定规则的数据
 *
 * 爬起邮箱地址
 */
public class RegexTest2 {

    public static void main(String[] args) throws IOException {
        //        List<String> list = getMails();
        List<String> list = getMailsByWeb();
        for (String ls : list) {
            System.out.println(ls);
        }

    }

    public static List<String> getMails() throws IOException {
        // 读取源文件
        BufferedReader bufr = new BufferedReader(new FileReader("f:\\mail.html"));
        // 对读取的数据进行规则的匹配，从而获取符合规则的数据
        String mail_regex = "\\w+@\\w+(\\.\\w+)*";
        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(mail_regex);
        String line = null;
        while ((line = bufr.readLine()) != null) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                list.add(m.group());
            }
        }
        return list;
    }

    public static List<String> getMailsByWeb() throws IOException {
        // 读取源文件
        URL url = new URL("http://bbs.ruoren.com/");
        BufferedReader bufr = new BufferedReader(new InputStreamReader(url.openStream()));
        // 对读取的数据进行规则的匹配，从而获取符合规则的数据
        String mail_regex = "\\w+@\\w+(\\.\\w+)*";
        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(mail_regex);
        String line = null;
        while ((line = bufr.readLine()) != null) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                list.add(m.group());
            }
        }
        return list;
    }
}
