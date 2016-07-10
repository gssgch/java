package com.thread.aaa;

//设计4个线程，其中两个每次对j增加1，另外两个线程对j每次减少1，
//

public class ThreadTest3 {

    /*
    private int j;
    public static void main(String[] args) {
    	ThreadTest3  tt2=new ThreadTest3();
    	Inc inc =tt2.new Inc();
    	Dec dec=tt2.new Dec();
    	for(int i=0;i<2;i++){
    		Thread t=new Thread(inc);
    		t.start();
    		t=new Thread(dec);
    		t.start();
    	}
    }
    
    
    private synchronized void inc(){
    	j++;
    	System.out.println(Thread.currentThread().getName()+"-inc:"+j);
    }
    
    private synchronized void dec(){
    	j++;
    	System.out.println(Thread.currentThread().getName()+"-dec:"+j);
    }
    
    
    class Inc implements Runnable{
    	public void run(){
    		for(int i=0;i<100;i++){
    			inc();
    		}
    	}
    }
    
    class Dec implements Runnable{
    	public void run(){
    		for(int i=0;i<100;i++){
    			dec();
    		}
    	}
    }
    */

    class A {
        JManager j = new JManager();

        void main() {
            new A().call();
        }

        void call() {
            for (int i = 0; i < 2; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            j.accumulate();
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            j.sub();
                        }
                    }
                }).start();
            }
        }
    }

    class JManager {
        private int j = 0;

        public synchronized void sub() {
            j--;
            System.out.println(Thread.currentThread().getName() + "-sub:" + j);
        }

        public synchronized void accumulate() {
            j++;
            System.out.println(Thread.currentThread().getName() + "-acc:" + j);
        }
    }
}
