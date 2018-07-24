package com.xp.java.datastructures.linked;

import com.xp.java.datastructures.stack_queues.queues.Queue;

/**
 * @类描述：用链表实现一个队列
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/24 0024 11:09
 * @修改人：
 * @修改时间：2018/7/24 0024 11:09
 * @修改备注：
 */
public class LinkedListQueue<T> implements Queue<T> {
    private LinkedList<T> list;

    public LinkedListQueue() {
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
    public void enqueue(T e) {
        list.addLast(e);
    }

    @Override
    public T dequeue() {
        return list.removeFirst();
    }

    @Override
    public T getFront() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        res.append(list);
        return res.toString();
    }
}
