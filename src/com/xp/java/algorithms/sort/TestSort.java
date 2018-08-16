package com.xp.java.algorithms.sort;

import com.xp.java.util.SortTestHelper;

/**
 * @类描述：测试排序类--主要用来比较各种排序
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/13 0013 15:35
 * @修改人：
 * @修改时间：2018/8/13 0013 15:35
 * @修改备注：
 */
public class TestSort {
    public static void main(String[] args) {
//        testSelectSort();
//        testInsertSort();
//        testShellSort();
//        testBubbleSort();
        testMergeSort();
        testQuickSort();

    }

    //选择排序
    private static void testSelectSort() {
        int N = 20000;
        //完全随机
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        //随机范围更小
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 3);
        //近乎有序的数组
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 20);
        SortTestHelper.testSort("com.xp.java.algorithms.sort.SelectSort", arr);
//        SortTestHelper.printArray(arr);
    }

    //插入排序
    //比较发现，插入排序的性能比选择排序差很多，但是在一些特殊情况，比如该数据大部分是有序的时候。
    //当我们用近乎有序的数组进行比较的时候 我们发现插入排序的效率相当高
    private static void testInsertSort() {
        int N = 20000;
        //完全随机
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        //随机范围更小
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 3);
        //近乎有序的数组
//        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 20);
        SortTestHelper.testSort("com.xp.java.algorithms.sort.InsertSort", arr);
//        SortTestHelper.printArray(arr);
    }

    //希尔排序
    //希尔排序是在插入排序的基础上，先进行数组分割，然后在逐步插入的排序，时间复杂度上因为分割，所以会比插入优越很多
    //同样是一个随机生成的输入，希尔排序要比插入排序 快很多
    private static void testShellSort() {
        int N = 20000;
        //完全随机
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        //随机范围更小
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 3);
        //近乎有序的数组
//        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 20);
        SortTestHelper.testSort("com.xp.java.algorithms.sort.ShellSort", arr);
//        SortTestHelper.printArray(arr);
    }

    //冒泡排序
    //比较以后发现 冒泡并没有什么优势，频繁的交换 比较耗时。
    private static void testBubbleSort() {
        int N = 20000;
        //完全随机
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        //随机范围更小
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 3);
        //近乎有序的数组
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 20);
        SortTestHelper.testSort("com.xp.java.algorithms.sort.BubbleSort", arr);
//        SortTestHelper.printArray(arr);
    }


    //归并排序
    private static void testMergeSort() {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.xp.java.algorithms.sort.MergeSort", arr);
        SortTestHelper.printArray(arr);
    }

    //归并排序
    private static void testQuickSort() {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.xp.java.algorithms.sort.QuickSort", arr);
        SortTestHelper.printArray(arr);
    }
}
