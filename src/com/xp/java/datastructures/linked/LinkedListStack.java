package com.xp.java.datastructures.linked;

import com.xp.java.datastructures.stack_queues.stack.Stack;

/**
 * @类描述：以链表实现的栈
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/24 0024 10:44
 * @修改人：
 * @修改时间：2018/7/24 0024 10:44
 * @修改备注：
 */
public class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T e) {
        list.addFirst(e);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
