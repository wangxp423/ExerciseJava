package com.xp.java.algorithms.sort;

import com.xp.java.util.SortTestHelper;

/**
 * @类描述：冒泡排序 1，依次比较两个连续的数据，然后就将最大的排到最后了
 * 2，然后在进行一轮
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/14 0014 11:06
 * @修改人：
 * @修改时间：2018/8/14 0014 11:06
 * @修改备注：
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(array);
        SortTestHelper.printArray(array);
    }

    public static void sort(Comparable[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Comparable temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
