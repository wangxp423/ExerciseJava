package com.xp.java.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @类描述：leetcode第102题，是一个队列遍历二叉树的。
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/20 0020 16:15
 * @修改人：
 * @修改时间：2018/7/20 0020 16:15
 * @修改备注：
 */
public class Solution_0102 {
    /// Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class Array<T> {

        private T[] data;
        private int size;

        // 构造函数，传入数组的容量capacity构造Array
        public Array(int capacity) {
            data = (T[]) new Object[capacity];
            size = 0;
        }

        // 无参数的构造函数，默认数组的容量capacity=10
        public Array() {
            this(10);
        }

        // 获取数组的容量
        public int getCapacity() {
            return data.length;
        }

        // 获取数组中的元素个数
        public int getSize() {
            return size;
        }

        // 返回数组是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        // 在index索引的位置插入一个新元素e
        public void add(int index, T e) {

            if (index < 0 || index > size)
                throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

            if (size == data.length)
                resize(2 * data.length);

            for (int i = size - 1; i >= index; i--)
                data[i + 1] = data[i];

            data[index] = e;

            size++;
        }

        // 向所有元素后添加一个新元素
        public void addLast(T e) {
            add(size, e);
        }

        // 在所有元素前添加一个新元素
        public void addFirst(T e) {
            add(0, e);
        }

        // 获取index索引位置的元素
        public T get(int index) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed. Index is illegal.");
            return data[index];
        }

        public T getLast() {
            return get(size - 1);
        }

        public T getFirst() {
            return get(0);
        }

        // 修改index索引位置的元素为e
        public void set(int index, T e) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Set failed. Index is illegal.");
            data[index] = e;
        }

        // 查找数组中是否有元素e
        public boolean contains(T e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e))
                    return true;
            }
            return false;
        }

        // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
        public int find(T e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e))
                    return i;
            }
            return -1;
        }

        // 从数组中删除index位置的元素, 返回删除的元素
        public T remove(int index) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Remove failed. Index is illegal.");

            T ret = data[index];
            for (int i = index + 1; i < size; i++)
                data[i - 1] = data[i];
            size--;
            data[size] = null; // loitering objects != memory leak

            if (size == data.length / 4 && data.length / 2 != 0)
                resize(data.length / 2);
            return ret;
        }

        // 从数组中删除第一个元素, 返回删除的元素
        public T removeFirst() {
            return remove(0);
        }

        // 从数组中删除最后一个元素, 返回删除的元素
        public T removeLast() {
            return remove(size - 1);
        }

        // 从数组中删除元素e
        public void removeElement(T e) {
            int index = find(e);
            if (index != -1)
                remove(index);
        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();
            res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
            res.append('[');
            for (int i = 0; i < size; i++) {
                res.append(data[i]);
                if (i != size - 1)
                    res.append(", ");
            }
            res.append(']');
            return res.toString();
        }

        // 将数组空间的容量变成newCapacity大小
        private void resize(int newCapacity) {

            T[] newData = (T[]) new Object[newCapacity];
            for (int i = 0; i < size; i++)
                newData[i] = data[i];
            data = newData;
        }
    }

    private interface Queue<E> {

        int getSize();

        boolean isEmpty();

        void enqueue(E e);

        E dequeue();

        E getFront();
    }

    private class ArrayQueue<E> implements Queue<E> {

        private Array<E> array;

        public ArrayQueue(int capacity) {
            array = new Array<>(capacity);
        }

        public ArrayQueue() {
            array = new Array<>();
        }

        @Override
        public int getSize() {
            return array.getSize();
        }

        @Override
        public boolean isEmpty() {
            return array.isEmpty();
        }

        public int getCapacity() {
            return array.getCapacity();
        }

        @Override
        public void enqueue(E e) {
            array.addLast(e);
        }

        @Override
        public E dequeue() {
            return array.removeFirst();
        }

        @Override
        public E getFront() {
            return array.getFirst();
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append("Queue: ");
            res.append("front [");
            for (int i = 0; i < array.getSize(); i++) {
                res.append(array.get(i));
                if (i != array.getSize() - 1)
                    res.append(", ");
            }
            res.append("] tail");
            return res.toString();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (null == root) return res;

        ArrayQueue<Pair<TreeNode, Integer>> queue = new ArrayQueue<>();
        queue.enqueue(new Pair<TreeNode, Integer>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> front = queue.dequeue();
            TreeNode node = front.getKey();
            int level = front.getValue();
            if (level == res.size()) {
                res.add(new ArrayList<Integer>());
            }
            assert level < res.size();

            res.get(level).add(node.val);
            if (node.left != null) {
                queue.enqueue(new Pair<TreeNode, Integer>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.enqueue(new Pair<TreeNode, Integer>(node.right, level + 1));
            }
        }
        return res;
    }
}
