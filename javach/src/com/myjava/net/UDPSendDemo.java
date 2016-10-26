package com.myjava.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("发送端启动。。。。。。。。。。。");
        /*
         * 创建UDP传输的发送端.
         * 思路：
         * 1，建立udp的socket服务
         * 2，将要发送的数据封装到数据包中
         * 3，通过udp的socket服务奖数据包发送出去
         * 4，关闭socket服务
         */

        // 1,udpsocket服务，使用DatagramSocket服务
        DatagramSocket ds = new DatagramSocket();

        // 传统单行
        //        // 2,将要发送的数据封装到数据包中
        //        String str = "udp演示，哥们来了！";
        //        // 使用DatagramPacket将数据封装到该对象包中
        //        byte[] buf = str.getBytes();

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bufr.readLine()) != null) {
            byte[] buf = line.getBytes();
            DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.104"), 10000);
            // 通过udp的socket服务奖数据包发送出去，使用send方法
            ds.send(dp);
            if ("over".equals(line)) {
                break;
            }
        }

        // 关闭资源
        ds.close();
    }

}
