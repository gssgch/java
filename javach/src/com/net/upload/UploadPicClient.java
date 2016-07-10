package com.net.upload;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UploadPicClient {

    public static void main(String[] args) throws Exception {
        // 创建客户端socket
        Socket s = new Socket("127.0.0.1", 10006);
        // 读取客户端要上传的文件
        FileInputStream fis = new FileInputStream("f:\\2.jpg");

        // 获取socket输出流，将读取到的图片数据发送给服务端
        OutputStream out = s.getOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            out.write(buf);
        }
        // 告诉服务端说：这边的数据发送完毕，让服务端停止读取
        s.shutdownOutput();
        InputStream in = s.getInputStream();
        byte[] bufIn = new byte[1024];
        int lenIn = in.read(buf);
        String text = new String(buf, 0, lenIn);

        System.out.println(text);

        fis.close();
        s.close();

    }

}
