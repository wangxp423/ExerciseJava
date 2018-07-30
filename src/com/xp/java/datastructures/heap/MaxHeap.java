package com.xp.java.datastructures.heap;

import com.xp.java.datastructures.array.ArrayT;

/**
 * @类描述：最大堆(根据二叉堆的特点，满二叉，我们可以根据父节点推出子节点位置，反之亦然)
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/30 0030 10:13
 * @修改人：
 * @修改时间：2018/7/30 0030 10:13
 * @修改备注：
 */
public class MaxHeap<T extends Comparable<T>> {
    //已知父节点 左子节点=index*2+1   右子节点=index*2+1
    //所以我们可以将堆，以数组的形式展现。
    private ArrayT<T> data; //用我们自己的数组

    public MaxHeap(int capacity) {
        data = new ArrayT<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayT<>();
    }

    public MaxHeap(T[] arr) {
        data = new ArrayT<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //根据子节点位置求父节点
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index=0 have no parent");
        }
        return (index - 1) / 2;
    }

    //根据父节点位置得到左子节点
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //根据父节点位置得到右子节点
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    //想堆中添加元素
    public void add(T e) {
        data.addLast(e); //先添加到数组中
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        //跟父节点比 如果比父节点大 上浮
        while (index > 0 && data.getIndex(parent(index)).compareTo(data.getIndex(index)) < 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    //查看堆中最大元素
    public T findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("can not find max when heap is empty");
        }
        return data.getIndex(0);
    }

    //取出堆中最大元素
    public T extractMax() {
        T max = findMax();
        data.swap(0, data.getSize() - 1); //将最大值和数组最后一个元素交换
        data.removeLast();//移除最后一个元素(最大值)
        siftDown(0);//将第一个元素进行下沉操作
        return max;
    }

    //下沉操作
    private void siftDown(int index) {
        while (leftChild(index) < data.getSize()) {
            int i = leftChild(index);//拿到父节点左子节点索引
            //比较两个子节点，然后取出大的节点的索引
            if (i + 1 < data.getSize() && data.getIndex(i + 1).compareTo(data.getIndex(i)) > 0) {
                i++;
            }
            if (data.getIndex(index).compareTo(data.getIndex(i)) >= 0) {
                break;
            }
            data.swap(index, i);
            index = i;
        }
    }

    //取出堆中最大元素，并替换成元素e
    public T replace(T e) {
        T max = findMax();
        data.setData(0, e);
        siftDown(0);
        return max;
    }
}
