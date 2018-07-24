package com.xp.java.datastructures.stack_queues.queues;

import com.xp.java.datastructures.array.ArrayT;

/**
 * @类描述：基于数组实现的队列
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/20 0020 14:44
 * @修改人：
 * @修改时间：2018/7/20 0020 14:44
 * @修改备注：
 */
public class ArrayQueue<T> implements Queue<T> {
    private ArrayT<T> array;

    public ArrayQueue(int capacity) {
        array = new ArrayT<>(capacity);
    }

    public ArrayQueue() {
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
    public void enqueue(T e) {
        array.addLast(e);
    }

    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.getIndex(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
