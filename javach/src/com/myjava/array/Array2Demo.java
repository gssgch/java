package com.myjava.array;

// 二维数组定义的格式
public class Array2Demo {

    public static void main(String[] args) {

        int[] ar = new int[3];

        int[][] arr = new int[3][2]; // 创建一个二维数组，该数组中有3个一维数组，每一个一维数组中有2个元素
        System.out.println(arr); // 直接打印二维数组  [[I@61de33
        System.out.println(arr[0]); // 直接打印二维数组中的角标0的一维数组。 [I@14318bb
        System.out.println(arr[0][0]); // 直接打印二维数组中的角标0的一维数组中角标为0的元素。 0

        int[][] arr2 = new int[3][]; // 创建一个二维数组
        System.out.println(arr2); // 直接打印二维数组  [[I@61de33
        System.out.println(arr2[0]); // 直接打印二维数组中的角标0的一维数组。 null
        System.out.println(arr2[0][0]); // 直接打印二维数组中的角标0的一维数组中角标为0的元素。报空指针异常

        int[][] arr3 = new int[3][2]; // 创建一个二维数组
        System.out.println(arr3.length); // 打印二维数组的长度，其实就是一维数组的个数。
        System.out.println(arr3[1].length); // 打印二维数组中角标为1的一维数组的长度

        // 二维数组的另一种定义方式
        int sum = 0;
        int[][] arr4 = { { 1 }, { 4, 3, 1 }, { 4, 1 } };
        for (int x = 0; x < arr4.length; x++) {
            for (int y = 0; y < arr4[x].length; y++) {
                System.out.println(arr4[x][y] + ",");
                sum += arr[x][y];
            }
        }
        System.out.println("sum=" + sum);
    }

}
