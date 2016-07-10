package com.pattern.dynamicproxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookImplProxy implements InvocationHandler {

    private Object target;

    //绑定委托对象，并返回一个代理类
    public Object bind(Object target) {
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
    }

    //调用方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        System.out.println("before...");
        //执行方法
        result = method.invoke(target, args);
        System.out.println("after...");
        return result;
    }

}
