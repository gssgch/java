package com.pattern.dynamicproxy.demo2;

public class TestCglib {

    public static void main(String[] args) {

        Book book = new BookImpl();
        BookImplProxy pro = new BookImplProxy();
        Book boProxy = (Book) pro.bind(book);//得到的是一个代理对象
        boProxy.addBook();
    }
}
