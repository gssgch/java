package com.pattern.dynamicproxy.demo1;

import java.lang.reflect.Proxy;

//测试
public class ProxyTest {

    public static void main(String[] args) {
        Hello impl = new HelloImpl();
        LogHandler handler = new LogHandler(impl);
        Hello hello = (Hello) Proxy.newProxyInstance(impl.getClass().getClassLoader(), impl.getClass().getInterfaces(), handler);

        hello.print("sgfg");
        System.out.println("---------");
        hello.sayHello("华仔");
    }
}
