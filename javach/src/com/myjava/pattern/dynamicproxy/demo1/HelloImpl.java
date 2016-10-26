package com.myjava.pattern.dynamicproxy.demo1;

//真实的实现类
public class HelloImpl implements Hello {

    @Override
    public void print(String bb) {
        System.out.println("print:" + bb);

    }

    @Override
    public void sayHello(String aa) {

        System.out.println("sayHello to:" + aa);
    }

}
