package com.baodian.abstractandInterface;

//关于final的一个问题举例
public class Test1 {

    public static void main(String[] args) {

        Other t = new Other();

        for (int j = 0; j < 10; j++) {
            new Test1().addOne(t);
            System.out.println(t.i);
        }
    }

    public void addOne(final Other t) {
        //		t=new Other();//因为Other t 被定义为final类型，所有不能再新new对象了，但是可以直接使用t
        t.i++;
    }
}

class Other {
    public int i;
}
