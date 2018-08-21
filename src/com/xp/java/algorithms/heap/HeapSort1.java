package com.xp.java.algorithms.heap;

import com.xp.java.datastructures.heap.MaxHeap;
import com.xp.java.util.SortTestHelper;

/**
 * @类描述：最大堆 排序  基于之前写的最大堆MaxHeap来
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/20 0020 11:12
 * @修改人：
 * @修改时间：2018/8/20 0020 11:12
 * @修改备注：
 */
public class HeapSort1 {
    public static void main(String[] args) {
        Integer[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int N = 20000;
        //完全随机
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.printArray(sort(arr));
    }

    //我们看到这个排序 需要两次遍历还有查找删除 复杂度在O²logn 不是一个优秀的算法
    //在HeapSort2中 有另外一种算法，我们可以在先有MaxHeap的基础上，传入一个数组，然后将这个数组根据堆性质
    //让这个数组变成一个最大堆，然后再用下面的方法，取出最大堆的元素 然后进行排序
    public static Integer[] sort(Integer[] array) {
        MaxHeap<Integer> heap = new MaxHeap<Integer>();
        for (int i = 0; i < array.length; i++) {
            heap.add(array[i]);
        }
        Integer[] sort = new Integer[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sort[i] = heap.extractMax();
        }
        return sort;
    }

    public static <T extends Comparable<T>> T[] sort(T[] array) {
        MaxHeap<T> heap = new MaxHeap<T>();
        for (int i = 0; i < array.length; i++) {
            heap.add(array[i]);
        }
        T[] sort = (T[]) new Comparable[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sort[i] = heap.extractMax();
        }
        return sort;
    }


}
