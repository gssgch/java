package com.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("接收端启动。。。。。。。");
        /*
         * 建立UDP接收端的思考
         * 1，建立upd  socket服务   因为是要接收数据，必须要明确一个端口号
         * 2， 创建数据包，用于存储接收到的数据，方便用数据包对象的方法解析这些数据
         * 3，使用socket服务的receive方法将接收的数据存储到数据包中
         * 4,通过数据包的方法解析数据包中的数据
         * 5，关闭资源
         */

        // 建立 udp socket服务
        DatagramSocket ds = new DatagramSocket(10000);

        // 创建数据包
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        // 使用接收方法将数据存储到数据包中
        ds.receive(dp);

        // 通过数据包对象的方法，解析其中的数据，比如：地址，端口，数据内容
        String ip = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        String text = new String(dp.getData(), 0, dp.getLength());
        System.out.println(ip + ":" + port + ":" + text);

        //关闭
        ds.close();
    }

}
