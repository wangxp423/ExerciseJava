package com.xp.java.stack_queues.stack;

/**
 * @类描述：栈
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/19 0019 18:22
 * @修改人：
 * @修改时间：2018/7/19 0019 18:22
 * @修改备注：
 */
public interface Stack<T> {
    int getSize();

    boolean isEmpty();

    void push(T e);

    T pop();

    T peek();
}
