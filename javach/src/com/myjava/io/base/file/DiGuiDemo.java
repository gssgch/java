package com.myjava.io.base.file;

public class DiGuiDemo {
    /*
     * 递归：
     * 函数自身直接或者间接地调用到了自身.
     *
     * 一个功能在被重复使用，并每次使用时，参与运算的结果和上一次调用有关，
     * 这时可以使用递归来解决问题。
     *
     * 注意：
     * 1,递归一定明确条件，否则容易栈溢出。
     * 2,注意递归的次数
     */
    public static void main(String[] args) {

        //        shows();
        //        toBin(7);
        System.out.println(getSum(7));
    }

    public static int getSum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + getSum(num - 1);
    }

    // 算二进制
    public static void toBin(int num) {
        /*  while (num > 0) {
              System.out.println(num % 2);
              num = num / 2;
          }*/// 常规方式
        // 递归方式
        if (num > 0) {
            System.out.println(num % 2);
            toBin(num / 2);
        }

    }

    // 没有出口，会报栈溢出
    /*    public static void shows() {
            method();
        }

        public static void method() {
            shows();
        }*/

}
