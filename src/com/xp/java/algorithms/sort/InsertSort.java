package com.xp.java.algorithms.sort;

import com.xp.java.util.SortTestHelper;

/**
 * @类描述：插入排序 1，先比较前两个大小，然后排序，
 * 2，然后在依次插入第三个，第四个进行排序
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/14 0014 10:23
 * @修改人：
 * @修改时间：2018/8/14 0014 10:23
 * @修改备注：
 */
public class InsertSort {
    public static void main(String[] args) {
        Integer[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(array);
        SortTestHelper.printArray(array);
    }

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    Comparable temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
