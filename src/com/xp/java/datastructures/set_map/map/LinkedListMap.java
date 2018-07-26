package com.xp.java.datastructures.set_map.map;

/**
 * @类描述：基于链表的Map
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/26 0026 14:26
 * @修改人：
 * @修改时间：2018/7/26 0026 14:26
 * @修改备注：
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (null != cur) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V val) {
        Node node = getNode(key);
        if (null == node) {
            dummyHead.next = new Node(key, val, dummyHead.next);
            size++;
        } else {
            node.value = val;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (null != prev.next) {//找要删除节点的上一个节点
            if (prev.next.key.equals(key))
                break;
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return null == node ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (null == node) {
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
