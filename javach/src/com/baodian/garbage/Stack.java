package com.baodian.garbage;

import java.util.EmptyStackException;

//内存泄露问题
public class Stack {

    private Object[] elements = new Object[10];
    private int size = 0;

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {

            throw new EmptyStackException();
        }
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            Object[] oldElements = elements;
            elements = new Object[(2 * elements.length) + 1];
            System.arraycopy(oldElements, 0, elements, 0, size);
        }
    }

    //假如堆栈加了10个元素，然后全部弹出来，虽然堆栈是空的，没有我们想要的东西，但是这个对象是无法回收的，
    //这个才符合内存泄露的两个条件：无用，无法回收
}
