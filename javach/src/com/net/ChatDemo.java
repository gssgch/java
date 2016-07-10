package com.net;

import java.net.DatagramSocket;

public class ChatDemo {

    public static void main(String[] args) throws Exception {
        DatagramSocket send = new DatagramSocket();
        DatagramSocket rece = new DatagramSocket(10000);
        new Thread(new SendDemo(send)).start();
        new Thread(new ReceDemo(rece)).start();

    }

}
