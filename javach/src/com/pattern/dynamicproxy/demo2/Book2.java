package com.pattern.dynamicproxy.demo2;

//没有实现接口的普通类，只能使用cglib实现动态代理
public class Book2 {

    public void addBook() {
        System.out.println("增加图书的普通方法----");
    }
}
