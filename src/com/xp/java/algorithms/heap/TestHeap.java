package com.xp.java.algorithms.heap;

import com.xp.java.util.SortTestHelper;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/14 0014 10:23
 * @修改人：
 * @修改时间：2018/8/14 0014 10:23
 * @修改备注：
 */
public class TestHeap {
    private static final int N = 200000;

    public static void main(String[] args) {
        //对比能感觉到第二种还是比第一种快一些的。
        testHeapSort1();
        testHeapSort2();
        testIndexHeapSort();
        testQuickSort();
    }

    //将输入插入MaxHeap中，然后在取出最大堆第一个元素，来进行排序
    private static void testHeapSort1() {
        //完全随机
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        //随机范围更小
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 3);
        //近乎有序的数组
//        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 20);
        SortTestHelper.testSort("com.xp.java.algorithms.heap.HeapSort1", arr);
//        SortTestHelper.printArray(arr);//这里不能这么打印，因为sort1中重新new 了数组。
    }

    //根据堆的性质，将数组自动生成最大堆，然后再将最大堆数组 转换排序
    private static void testHeapSort2() {
        //完全随机
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        //随机范围更小
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 3);
        //近乎有序的数组
//        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 20);
        SortTestHelper.testSort("com.xp.java.algorithms.heap.HeapSort2", arr);
//        SortTestHelper.printArray(arr);
    }

    //几次测试对比 发现索引堆排序 时间上和HeapSort2并没有明显的优势
    //主要是因为操作对象都是Integer，对象包含数据量不大，体现不出索引堆的优势。
    private static void testIndexHeapSort() {
        //完全随机
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        //随机范围更小
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 3);
        //近乎有序的数组
//        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 20);
        SortTestHelper.testSort("com.xp.java.algorithms.heap.IndexHeapSort", arr);
//        SortTestHelper.printArray(arr);
    }

    //快速排序
    private static void testQuickSort() {
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.xp.java.algorithms.sort.QuickSort", arr);
//        SortTestHelper.printArray(arr);
    }
}
