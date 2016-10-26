package com.myjava.net.upload;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(10005);

        Socket s = ss.accept();

        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + " ---connect");

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bufw = new BufferedWriter(new FileWriter("f:\\aaa.txt"));

        String line = null;
        while ((line = bufIn.readLine()) != null) {
            //            if ("over".equals(line)) {
            //                break;
            //            }
            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("上传成功");
        bufw.close();
        s.close();
        ss.close();
    }

}
