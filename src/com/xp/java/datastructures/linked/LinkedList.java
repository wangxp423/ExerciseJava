package com.xp.java.datastructures.linked;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/23 0023 16:07
 * @修改人：
 * @修改时间：2018/7/23 0023 16:07
 * @修改备注：
 */
public class LinkedList<T> {
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
    }

    private Node dummyHead; //虚拟头节点，好处是，不用维护真实头节点，代码更好书写
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    //获取链表中数据的个数
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) { //找到index位置的上一个节点
            pre = pre.next;
        }
        //新建一个节点，将改节点的next指向pre节点的next,然后 pre.next指向新建节点
//            Node node = new Node(e);
//            node.next = pre.next;
//            pre.next = node;
        pre.next = new Node(e, pre.next);
        size++;
    }

    public void addLast(T e) {
        add(size, e);
    }

    //在头部添加一个元素，不要忘了设置head.next
    public void addFirst(T e) {
        add(0, e);
    }

    //获取链表第index位置的元素
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) { //找到index位置的上一个节点
            cur = cur.next;
        }
        return cur.e;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public boolean contains(T e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

    public void set(int index, T e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) { //找到当前节点的上一个节点
            pre = pre.next;
        }
        Node cur = pre.next;
        pre.next = cur.next;
        cur.next = null;
        size--;
        return cur.e;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T e) {
//        return removeElement(dummyHead.next,e);  我们可以使用递归来写，但是每次都遍历到最后
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e.equals(e))
                break;
            pre = pre.next;
        }
        Node del = pre.next;
        pre.next = del.next;
        del.next = null;
        size--;
    }

    private Node removeElement(Node node, T e) {
        if (node == null) return null;
        node.next = removeElement(node.next, e);
        if (node.e.equals(e)) {
            return node.next;
        } else {
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur.e + "->");
        }
        res.append("NULL");
        res.append("    size = " + size);
        return res.toString();
    }
}
