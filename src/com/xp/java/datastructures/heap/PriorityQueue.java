package com.xp.java.datastructures.heap;

import com.xp.java.datastructures.stack_queues.queues.Queue;

/**
 * @类描述：优先队列
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/31 0031 9:54
 * @修改人：
 * @修改时间：2018/7/31 0031 9:54
 * @修改备注：
 */
public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {
    private MaxHeap<T> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(T e) {
        maxHeap.add(e);
    }

    @Override
    public T dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public T getFront() {
        return maxHeap.findMax();
    }
}
