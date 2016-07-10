package com.pattern.singleton;

//单例模式       三种写法：饥汉模式(有缺陷)，饱汉模式，枚举方式
public class SingletonPattern {

    //饥汉模式
    /*    private static SingletonPattern singleton=null;
        //私有化构造方法，不能直接new对象
        private SingletonPattern(){

        }
        public SingletonPattern getInstance(){
            if(this.singleton==null){
                this.singleton=new SingletonPattern();
            }
            return this.singleton;
        }*/

    //问题：假设现在有两个线程a和b,线程A执行到this.singleton=new SingletonPattern(),
    //正在申请分配内存，需要0.0001微秒，就在这0.0001微秒之内，线程B执行到if(this.singleton==null),
    //为true,于是就产生了两个SingletonPattern实例
    //方法2：饱汉模式
    private static final SingletonPattern singleton = new SingletonPattern();

    private SingletonPattern() {
        //私有化构造方法   就限定实例唯一
    }

    //synchronized：同步
    public synchronized static SingletonPattern getInstance() {
        return singleton;
    }
    //直接new 一个对象传递给类的成员变量singleton，调用的时候getInstance（）直接返回这个实例

    //改进方法的优缺点：称为饱含模式，能完全保证实例唯一，实例化放在静态代码块里可提高程序的执行效率，但也可能更占用空间
}
