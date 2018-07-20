package com.xp.java.stack_queues.queues;

/**
 * @类描述：基于数组的循环队列
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/20 0020 15:09
 * @修改人：
 * @修改时间：2018/7/20 0020 15:09
 * @修改备注：
 */
public class LoopQueue<T> implements Queue<T> {
    private T[] data;
    private int size, front, tail;

    public LoopQueue(int capacity) {
        //为什么这个地方要+1  不加的话我们会发现比如设置容量是5
        // 当我们入队第五个元素的时候 发现应该是刚刚满  但是却扩容了。这样做更省事
        data = (T[]) new Object[capacity + 1];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(T e) {
        if ((tail + 1) % data.length == front) {
            resize(2 * data.length);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from empty queue");
        }
        T e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return e;
    }

    @Override
    public T getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    private void resize(int newCapacity) {
        T[] array = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            array[i] = data[(front + i) % data.length];
        }
        data = array;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
