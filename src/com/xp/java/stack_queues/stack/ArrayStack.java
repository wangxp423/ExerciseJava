package com.xp.java.stack_queues.stack;

import com.xp.java.array.ArrayT;

/**
 * @类描述：数组栈
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/19 0019 18:30
 * @修改人：
 * @修改时间：2018/7/19 0019 18:30
 * @修改备注：
 */
public class ArrayStack<T> implements Stack<T> {
    private ArrayT<T> array;

    public ArrayStack(int capacity) {
        array = new ArrayT<>(capacity);
    }

    public ArrayStack() {
        array = new ArrayT<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(T e) {
        array.addLast(e);
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.getIndex(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
