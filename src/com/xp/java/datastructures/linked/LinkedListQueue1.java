package com.xp.java.datastructures.linked;

import com.xp.java.datastructures.stack_queues.queues.Queue;

/**
 * @类描述：我们知道队列的特殊性，入队在队尾，出队在对首，为了减少操作复杂度，我们可以像数组的循环队列一样，在链表的头和尾分别加一个虚拟节点。
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/24 0024 14:52
 * @修改人：
 * @修改时间：2018/7/24 0024 14:52
 * @修改备注：
 */
public class LinkedListQueue1<T> implements Queue<T> {
    private class Node {
        public T e;
        public Node next;

        public Node(T e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(T e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    private Node head, tail;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T e) {
        // = 指向的同一个内存地址
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) tail = null;
        size--;
        return retNode.e;
    }

    @Override
    public T getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
