package com.xp.java.datastructures.set_map.set;

import com.xp.java.datastructures.linked.LinkedList;

/**
 * @类描述：基于链表的set
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/26 0026 9:53
 * @修改人：
 * @修改时间：2018/7/26 0026 9:53
 * @修改备注：
 */
public class LinkedListSet<T> implements Set<T> {
    private LinkedList<T> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(T e) {
        if (!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public boolean contains(T e) {
        return linkedList.contains(e);
    }

    @Override
    public void remove(T e) {
        linkedList.removeElement(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
