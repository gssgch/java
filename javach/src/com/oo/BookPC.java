package com.oo;

/*
 * 笔记本电脑使用
 * 为了扩展笔记本的功能，但日后出现什么功能设备不知道
 *
 * 定义一个规则，只要日后出现的设备都符合这个规则就可以了
 * 规则在java中就是一个接口
 */

public class BookPC {

    public static void main(String[] args) {
        useUSB(new UPan()); // 功能扩展了
        useUSB(new UsbMouse());
    }

    public static void useUSB(USB u) { // 接口类型的引用，用于接收(指向)接口的子类对象
        u.open();
        u.close();
    }

}

interface USB { // 暴露的规则
    public void open();

    public void close();
}

// 一年后 -----------------
// 实现规则

// 这些设备和电脑的耦合性降低了
class UPan implements USB {

    @Override
    public void open() {
        // TODO Auto-generated method stub
        System.out.println("upan open");
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        System.out.println("upan close");

    }

}

// 实现规则
class UsbMouse implements USB {

    @Override
    public void open() {
        // TODO Auto-generated method stub
        System.out.println("mouse open");
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        System.out.println("mouse close");

    }

}
