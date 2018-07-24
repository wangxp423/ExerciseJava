package com.xp.java.datastructures.array;

/**
 * @类描述：数组实现
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/18 0018 11:16
 * @修改人：
 * @修改时间：2018/7/18 0018 11:16
 * @修改备注：
 */
public class Array {
    private int[] data;
    private int size;

    //有参构造 传入数组长度
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    //无参函数 默认长度10
    public Array() {
        this(10);
    }

    //容量
    public int getCapacity() {
        return data.length;
    }

    //数组长度
    public int getSize() {
        return size;
    }

    //是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //删除指定位置的元素
    public int remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed,Require index >= 0 and index <= size .");

        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void removeElement(int e) {
        int index = findIndex(e);
        if (index != -1) {
            remove(index);
        }
    }

    //在index位置添加元素
    public void add(int index, int e) {
        if (size == data.length)
            throw new IllegalArgumentException("Add Failed,The Array is full");
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed,Require index >= 0 and index <= size .");
        for (int i = size - 1; index <= i; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(int e) {
        add(0, e);
    }

    public void addLast(int e) {
        add(size, e);
    }

    public int getIndex(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed,Require index >= 0 and index <= size .");
        return data[index];
    }

    public void setData(int index, int e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed,Require index >= 0 and index <= size .");
        data[index] = e;
    }

    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) return true;
        }
        return false;
    }

    public int findIndex(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) return i;
        }
        return -1;
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
}
