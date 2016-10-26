package com.myjava.thread.base.resource;

/* 线程间通讯
   代码优化
 *
 */
public class ResourceDemo2 {

    public static void main(String[] args) {
        // 创建资源
        Resource2 r = new Resource2();
        // 创建任务
        Input2 in = new Input2(r);
        Output2 out = new Output2(r);
        // 创建线程，执行路径
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        // 开启线程
        t1.start();
        t2.start();
    }

}

class Resource2 {
    private String name;
    private String sex;
    private boolean flag = false;

    public synchronized void set(String name, String sex) {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }

    public synchronized void out() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + "........." + sex);
        flag = false;
        this.notify();
    }
}

// 输入
class Input2 implements Runnable {
    Resource2 r;

    Input2(Resource2 r) {
        this.r = r;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            if (x == 0) {
                r.set("mike", "man");
            } else {
                r.set("张三", "m女");
            }
            x = (x + 1) % 2;
        }
    }
}

// 输出
class Output2 implements Runnable {
    Resource2 r;

    Output2(Resource2 r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.out();
        }
    }

}
