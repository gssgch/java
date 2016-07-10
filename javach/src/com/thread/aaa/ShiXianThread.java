package com.thread.aaa;


public class ShiXianThread {

    public static void main(String[] args) {

        //java中实现线程的几种方式
        //	第一种：new Thread(){}.start():表示调用Thread子类对象的run方法
        //	继承Thread类，直接调用thread的run方法，经常使用Thread的子类，即newSubThread()
        new Thread() {
            @Override
            public void run() {
            }
        }.start();
        //	}
        //	第二种 new Thread(new Runnable(){}).start():
        //	实现runnable接口，调用Runnable 对象的run方法
        new Thread(new Runnable() {
            @Override
            public void run() {
            }
        }).start();

    }
    //从java5开始，还有如下一些线程池创建多线程的方式

    /*
    ExecutorService pool =Executors.newFixedThreadPool(3){
       for(int i=0;i<10;i++){
    	   pool.execute(new Runnable(){
    		   public void run(){}
    	   });
       };
    }
    //带缓存的线程池
    ExecutorService.newCachedThreadPool().execute(new Runnable(){
    	public void run(){}
    });
    
    Executor.newSingleThreadExecutor().execute(new Runnable(){
    	public void run(){}
    });
    */
}
