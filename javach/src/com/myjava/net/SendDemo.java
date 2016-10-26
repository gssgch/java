package com.myjava.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo implements Runnable {

    private DatagramSocket ds;

    public SendDemo(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            while (true) {
                BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                while ((line = bufr.readLine()) != null) {
                    byte[] buf = line.getBytes();
                    // 把ip地址改为255   发广播，同一ip段的都能
                    DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.255"), 10000);
                    ds.send(dp);

                    if ("886".equals(line)) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the ds
     */
    public DatagramSocket getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(DatagramSocket ds) {
        this.ds = ds;
    }

}
