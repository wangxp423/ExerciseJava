package com.xp.java.algorithms.sort;

import com.xp.java.util.PrintUtil;

/**
 * @类描述：选择排序
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/13 0013 15:36
 * @修改人：
 * @修改时间：2018/8/13 0013 15:36
 * @修改备注：
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        PrintUtil.printArray("选择排序：", selectSort(array));

    }

    //从小到大的排序
    private static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
}
