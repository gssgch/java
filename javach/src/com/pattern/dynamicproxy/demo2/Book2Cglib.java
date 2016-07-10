package com.pattern.dynamicproxy.demo2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Book2Cglib implements MethodInterceptor {

    private Object target;

    //创建代理对象
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        return enhancer.create();

    }

    @Override
    public Object intercept(Object obj, Method method, Object[] arg2, MethodProxy proxy) throws Throwable {

        System.out.println("begin....");
        proxy.invokeSuper(obj, arg2);
        System.out.println("end....");
        return null;
    }

}
