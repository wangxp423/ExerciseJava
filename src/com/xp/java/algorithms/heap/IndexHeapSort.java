package com.xp.java.algorithms.heap;

import com.xp.java.datastructures.heap.IndexMaxHeap;
import com.xp.java.util.SortTestHelper;

/**
 * @类描述：基于最大索引堆 的堆排序
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/20 0020 18:24
 * @修改人：
 * @修改时间：2018/8/20 0020 18:24
 * @修改备注：
 */
public class IndexHeapSort {
    public static void main(String[] args) {
        Integer[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(array);
        SortTestHelper.printArray(array);
    }

    public static void sort(Comparable[] array) {
        int n = array.length;
        IndexMaxHeap<Comparable> indexMapHeap = new IndexMaxHeap<>(array.length);
        for (int i = 0; i < n; i++) {
            indexMapHeap.insert(i, array[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            array[i] = indexMapHeap.extractMax();
        }
    }

}
