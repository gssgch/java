package com.net.upload;

import java.net.ServerSocket;
import java.net.Socket;

// 对服务器端任务进行封装
public class UploadPicServer2 {

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(10006);
        while (true) {
            Socket s = ss.accept();
            new Thread(new UploadTask(s)).start();
        }
    }

}
