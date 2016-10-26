package com.myjava.net.upload;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UploadClient {

    public static void main(String[] args) throws Exception {

        Socket s = new Socket("127.0.0.1", 10005);

        BufferedReader bufr = new BufferedReader(new FileReader("f:\\aa.txt"));

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        String line = null;
        while ((line = bufr.readLine()) != null) {
            out.println(line);
        }
        // 告诉服务端，客户端写完了
        s.shutdownOutput();
        //        out.println("over"); // 给个结束标记
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String str = bufIn.readLine();
        System.out.println(str);

        bufr.close();
        s.close();
    }

}
