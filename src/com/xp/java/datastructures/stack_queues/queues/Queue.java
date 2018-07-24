package com.xp.java.datastructures.stack_queues.queues;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/20 0020 14:40
 * @修改人：
 * @修改时间：2018/7/20 0020 14:40
 * @修改备注：
 */
public interface Queue<T> {
    int getSize();

    boolean isEmpty();

    void enqueue(T e);

    T dequeue();

    T getFront();
}
