package com.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

    public static void main(String[] args) throws IOException {
        String str_url = "http://127.0.0.1:8080/";
        URL url = new URL(str_url);
        //        System.out.println("url.getProtocol:" + url.getProtocol());
        //        System.out.println("url.getHost():" + url.getHost());
        //        System.out.println("url.getPort():" + url.getPort());
        //        System.out.println("url.getFile():" + url.getFile());
        //        System.out.println("url.getPath():" + url.getPath());
        //        System.out.println("url.getQuery:" + url.getQuery());

        /*      InputStream in = url.openStream();
                byte[] buf = new byte[1024];
                int len = in.read(buf);
                String text = new String(buf, 0, len);
                System.out.println(text);
                in.close();*/

        //获取url对象的url连接器对象，将连接封装成对象。java中内置的可以解析的具体协议的对象+socket
        URLConnection conn = url.openConnection();

        String value = conn.getHeaderField("Content-Type"); //
        System.out.println(value);// text/html

        System.out.println(conn);
        //        sun.net.www.protocol.http.HttpURLConnection:http://127.0.0.1:8080/

        InputStream in = conn.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String text = new String(buf, 0, len);
        System.out.println(text);
        in.close();
    }
}
