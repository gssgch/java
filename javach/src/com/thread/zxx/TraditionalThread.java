package com.thread.zxx;

// 新建线程的两种方式
public class TraditionalThread {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // 创建线程的方式1  new Thread的子类
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1:" + Thread.currentThread().getName());
                    System.out.println("2:" + this.getName());
                }
            }
        };
        thread.start();

        // 创建线程的方式2
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1:" + Thread.currentThread().getName());

                }

            }
        });
        thread2.start();

        //        new Thread( new Runnable  run){ run }.start();
        // 这种方式的代码，运行的是其子类的run方法，只有在本身没有覆盖run方法时才会去找其父，就是Runnable的run方法

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 不执行
                    System.out.println("runnable :" + Thread.currentThread().getName());

                }
            }
        }) {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 执行
                    System.out.println("thread :" + Thread.currentThread().getName());

                }
            }
        }.start();

    }

}
