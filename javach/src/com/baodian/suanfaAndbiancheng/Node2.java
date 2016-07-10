package com.baodian.suanfaAndbiancheng;

import java.util.Arrays;

//还是二叉树
public class Node2 {

    private int value;
    private Node2 left;
    private Node2 right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node2 getLeft() {
        return left;
    }

    public void setLeft(Node2 left) {
        this.left = left;
    }

    public Node2 getRight() {
        return right;
    }

    public void setRight(Node2 right) {
        this.right = right;
    }

    public Node2(int value) {
        this.value = value;
    }

    public void add(int value) {
        if (value > this.value) {
            if (right != null) {
                right.add(value);
            } else {
                Node2 node = new Node2(value);
                right = node;
            }
        } else {
            if (left != null) {
                left.add(value);
            } else {
                Node2 node = new Node2(value);
                left = node;
            }
        }
    }

    public boolean find(int value) {
        if (value == this.value) {
            return true;
        } else if (value > this.value) {
            if (right == null) {
                return false;
            } else {
                return right.find(value);
            }
        } else {
            if (left == null) {
                return false;
            } else {
                return left.find(value);
            }
        }
    }

    public void display() {
        System.out.println(value);
        if (left != null) {
            left.display();
        }
        if (right != null) {
            right.display();
        }
    }

    public static void main(String[] args) {
        int[] values = new int[8];
        for (int i = 0; i < 8; i++) {
            int num = (int) (Math.random() * 15);
            //System.out.println(num);
            if (!contains(values, num)) {
                values[i] = num;
            } else {
                i--;
            }
        }
        System.out.println(Arrays.toString(values));
        Node2 root = new Node2(values[0]);
        for (int i = 1; i < values.length; i++) {
            root.add(values[i]);
        }
        System.out.println(root.find(13));
        root.display();
    }

    public static boolean contains(int[] arr, int value) {
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }
}
