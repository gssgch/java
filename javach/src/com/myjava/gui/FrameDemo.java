package com.myjava.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {

    public static void main(String[] args) {
        Frame f = new Frame();
        //        f.setSize(500, 400); // 横轴   纵轴
        //        f.setLocation(400, 150);
        f.setBounds(400, 200, 500, 400);
        f.setLayout(new FlowLayout()); // 设置流式布局
        Button but = new Button("点我啊！");
        f.add(but); // 将按钮添加到窗体中

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("closing ............" + e);
                System.exit(0);
            }
        });

        but.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button  run........");
                System.exit(0);
            }
        });

        f.setVisible(true); // 窗口可见
        System.out.println("over");
    }
}
