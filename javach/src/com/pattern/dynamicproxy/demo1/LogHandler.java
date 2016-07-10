package com.pattern.dynamicproxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

    private Object dele;

    public LogHandler(Object obj) {
        this.dele = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object result = method.invoke(dele, args);
        after();
        return result;
    }

    public void doBefore() {
        System.out.println("before........");
    }

    public void after() {
        System.out.println("after.........");
    }

}
