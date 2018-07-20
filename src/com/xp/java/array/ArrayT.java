package com.xp.java.array;

/**
 * @类描述：数组实现(支持泛型)(扩展为动态数组)
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/18 0018 11:16
 * @修改人：
 * @修改时间：2018/7/18 0018 11:16
 * @修改备注：
 */
public class ArrayT<T> {
    private T[] data;
    private int size;

    //有参构造 传入数组长度
    public ArrayT(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    //无参函数 默认长度10
    public ArrayT() {
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
    public T remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed,Require index >= 0 and index <= size .");
        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) resize(data.length / 2);
        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T e) {
        int index = findIndex(e);
        if (index != -1) {
            remove(index);
        }
    }

    //在index位置添加元素
    public void add(int index, T e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed,Require index >= 0 and index <= size .");

        if (size == data.length) resize(2 * data.length);

        for (int i = size - 1; index <= i; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(T e) {
        add(0, e);
    }

    public void addLast(T e) {
        add(size, e);
    }

    public T getIndex(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed,Require index >= 0 and index <= size .");
        return data[index];
    }

    public T getFirst() {
        return getIndex(0);
    }

    public T getLast() {
        return getIndex(size - 1);
    }

    public void setData(int index, T e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed,Require index >= 0 and index <= size .");
        data[index] = e;
    }

    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return true;
        }
        return false;
    }

    public int findIndex(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) return i;
        }
        return -1;
    }

    public void resize(int capacity) {
        T[] array = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            array[i] = data[i];
        }
        data = array;
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
