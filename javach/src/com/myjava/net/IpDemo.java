package com.myjava.net;

import java.io.IOException;
import java.net.InetAddress;

public class IpDemo {
    public static void main(String[] args) throws IOException {
        //获取本地主机IP地址
        InetAddress ip = InetAddress.getLocalHost();
        //获取其他主机的IP地址对象
        ip = InetAddress.getByName("www.baidu.com");
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());

    }
}
