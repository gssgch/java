package com.pattern.dynamicproxy.demo2;

public class TestProxy {

    public static void main(String[] args) {

        Book2Cglib cglib = new Book2Cglib();
        Book2 bookCglib = (Book2) cglib.getInstance(new Book2());
        bookCglib.addBook();
    }
}
