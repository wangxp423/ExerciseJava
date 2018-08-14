package com.xp.java.algorithms.sort;

import com.xp.java.util.SortTestHelper;
import com.xp.java.util.TestUtil;

/**
 * @类描述：希尔排序
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/14 0014 14:52
 * @修改人：
 * @修改时间：2018/8/14 0014 14:52
 * @修改备注：
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {80, 30, 60, 40, 20, 10, 50, 70};
        shellSort(array, array.length);
        TestUtil.printArray("希尔排序：", array);
        shellSort1(array);
        TestUtil.printArray("希尔排序：", array);
        shellSort2(array, array.length);
        TestUtil.printArray("希尔排序：", array);
        Double[] arr = {7.8, 9.9, 10.0, 6.6, 5.4, 3.4};
        sort(arr);
        SortTestHelper.printArray(arr);
    }

    public static void sort(Comparable[] array) {
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < array.length; j = j + gap) {
                    if (array[j].compareTo(array[j - gap]) < 0) {
                        Comparable newInsert = array[j];
                        int k = j - gap;//前一个数的索引，如果前面的比新插入的大，交换位置。
                        while (k >= 0 && array[k].compareTo(newInsert) > 0) {
                            SortTestHelper.swap(array, k, k + gap);
                            k = k - gap;
                        }
                    }
                }
            }
        }
    }

    public static void shellSort(int[] a, int n) {

        // gap为步长，每次减为原来的一半。
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0; i < gap; i++) {

                for (int j = i + gap; j < n; j = j + gap) {

                    // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
                    if (a[j] < a[j - gap]) {
                        int tmp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k] > tmp) {
                            a[k + gap] = a[k];
                            k = k - gap;
                        }
                        a[k + gap] = tmp;
                    }
                }
            }
        }
    }

    public static void shellSort1(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    swap(arr, j, j - gap);
                    j = j - gap;
                }
            }
        }
    }

    public static void shellSort2(int[] a, int n) {

        // gap为步长，每次减为原来的一半。
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0; i < gap; i++) {

                for (int j = i + gap; j < n; j = j + gap) {

                    // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
                    if (a[j] < a[j - gap]) {
                        int tmp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k] > tmp) {
                            swap(a, k, k + gap);
                            k = k - gap;
                        }
                    }
                }
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

}
