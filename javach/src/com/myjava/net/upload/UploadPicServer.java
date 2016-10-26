package com.myjava.net.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(10006);
        // 获取客户端
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "....connected");
        // 读取客户端发来的数据
        InputStream in = s.getInputStream();

        // 将读取到的数据存储到一个文件中
        File dir = new File("f:\\");

        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, ip + ".bmp");
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        // 获取socket输出流，将上传成功消息发送给客户端
        OutputStream out = s.getOutputStream();
        out.write("上传成功".getBytes());
        fos.close();
        s.close();
        ss.close();
    }

}
