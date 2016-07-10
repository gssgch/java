package com.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MytomcatDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress() + ".......connected");
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String text = new String(buf, 0, len);
        System.out.println(text);
        // 给客户端一个反馈信息
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.print("<font color='red' size='7'>欢迎光临</font>");
        s.close();
        ss.close();
    }

    /*
     *  GET / HTTP/1.1     请求行，请求方式
     *  Accept: text/html, application/xhtml+xml,
     *  Accept-Language: zh-CN
     *  User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)
     *  Accept-Encoding: gzip, deflate    支持的压缩方式
     *  Host: 127.0.0.1:9090
     *  Connection: Keep-Alive   连接保持存活       还有一个值为close
     *
     */

}
