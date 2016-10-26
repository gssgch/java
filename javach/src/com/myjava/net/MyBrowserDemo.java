package com.myjava.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyBrowserDemo {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("127.0.0.1", 8080);
        // 模拟浏览器，给tomcat服务端发送符合http协议的请求消息
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("GET / HTTP/1.1");
        out.println("Accept: text/html");
        out.println("Host: 127.0.0.1:8080");
        out.println("Connection: Keep-Alive");
        out.println();
        out.println();

        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);
        String str = new String(buf, 0, len);
        System.out.println(str);
        s.close();
    }

    /*
     * 服务端发回应消息
     *  HTTP/1.1 200 OK  // 应答行    http的协议版本   应答状态码   应答状态信息描述
        Server: Apache-Coyote/1.1    应答消息属性信息。   属性名：属性值
        Accept-Ranges: bytes
        ETag: W/"7777-1294653210000"
        Last-Modified: Mon, 10 Jan 2011 09:53:30 GMT
        Content-Type: text/html
        Content-Length: 7777
        Date: Thu, 31 Jul 2014 14:43:24 GMT
        //空行
        // 应答体
     *
     *
     */
}
