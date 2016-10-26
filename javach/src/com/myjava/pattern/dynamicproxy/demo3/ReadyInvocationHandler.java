package com.myjava.pattern.dynamicproxy.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ReadyInvocationHandler implements InvocationHandler {

    private Object zhangsan = null;

    public ReadyInvocationHandler(Object realSubject) {
        this.zhangsan = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            /*
            动态代理类$Proxy0调用xiangQin方法时会调用它自己的xiangQin方法， 
            * 而它自己的xiangQin方法里面调用的是super.h.invoke(this, , )，也就是父类Proxy的h的invoke方法， 
            * 也就是ReadyInvocationHandler类的invoke方法。 
            * 所以，invoke(Object proxy,Method m, Object[] args)种的proxy实际上就是动态代理类$Proxy0， 
            * 如果你将其强转成XiangQinInterface然后调用它的xiangQin方法，然后它就会调用super.h.invoke(this, , )，这样就会死循环。 
            * 网上关于这里最多问题就是Object proxy放在这里用来做什么呢？这个我也不知道， 
            * 不过至少我们知道它到底是个什么东西，具体做什么用嘛就不得而知了 
            */
            System.out.println(proxy.getClass().getSimpleName());
            System.out.println("张三相亲前，代理人给他打扮了打扮。");
            result = method.invoke(zhangsan, args);
        } catch (Exception ex) {
            System.exit(1);
        }
        return result;
    }

}
