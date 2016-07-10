package com.thread.base.resource;

/* 线程间通讯
 * 多个线程在处理同一资源，但是任务却不同
 *
 */
public class ResourceDemo {

    public static void main(String[] args) {
        // 创建资源
        Resource1 r = new Resource1();
        // 创建任务
        Input1 in = new Input1(r);
        Output1 out = new Output1(r);
        // 创建线程，执行路径
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        // 开启线程
        t1.start();
        t2.start();
    }

}

class Resource1 {
    String name;
    String sex;
}

// 输入
class Input1 implements Runnable {
    Resource1 r;

    Input1(Resource1 r) {
        this.r = r;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            synchronized (r) { // 加同步

                if (x == 0) {
                    r.name = "mike";
                    r.sex = "man";
                } else {
                    r.name = "张三";
                    r.sex = "wemon";
                }
            }
            x = (x + 1) % 2;
        }
    }
}

// 输出
class Output1 implements Runnable {
    Resource1 r;

    Output1(Resource1 r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (r) {
                System.out.println(r.name + "........." + r.sex);
            }
        }
    }

}
