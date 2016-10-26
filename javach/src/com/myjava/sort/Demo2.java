package com.myjava.sort;

//将两个二维数组中对应位置上的整数进行相加
public class Demo2 {

    public static void main(String[] args) {
        int[][] a1 = new int[][] { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 9 } };
        int[][] a2 = new int[][] { { 10, 11, 22 }, { 33, 24, 55 },
                { 66, 27, 19 } };
        int[][] a3 = new int[3][3];

        System.out.println("遍历第一个 数组：");
        for (int[] b : a1) {
            for (int n : b) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
        System.out.println("遍历第二个 数组：");
        for (int[] b : a2) {
            for (int n : b) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a3[i][j] = a1[i][j] + a2[i][j];
            }
        }
        System.out.println("遍历第三个 数组：");
        for (int[] b : a3) {
            for (int n : b) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

}
