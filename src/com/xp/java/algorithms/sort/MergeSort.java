package com.xp.java.algorithms.sort;

import com.xp.java.util.TestUtil;

import java.util.Arrays;

/**
 * @类描述：归并排序
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/15 0015 11:37
 * @修改人：
 * @修改时间：2018/8/15 0015 11:37
 * @修改备注：
 */
public class MergeSort {
    public static void main(String[] args) {
//        mergeArray();
        testMergeArray();
//        Integer[] array = new Integer[]{14,12,15,13,11,16};
//        sort(array);
//        SortTestHelper.printArray(array);
    }

    public static void sort(Comparable[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(Comparable[] array, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    private static void merge(Comparable[] array, int start, int mid, int end) {
        //复制 array数组中 从start 到 end 位置的数组。注意这里，不一定是0-length。也有可能是中间段
        Comparable[] temp = Arrays.copyOfRange(array, start, end + 1);
        int i = start; //左半部分索引
        int j = mid + 1;//右半部分索引
        for (int k = start; k <= end; k++) {
            //我们这里的操作是以 temp数组(临时)空间作为比较 然后去重新复制array数组中对应位置的元素
            if (i > mid) {//说明左半部分已经处理完毕，直接将右半部分剩余的放进去即可
                array[k] = temp[j - start];
                j++;
            } else if (j > end) {//说明右半部分已经处理完毕，直接将左半部分剩余的放进去即可
                array[k] = temp[i - start];
                i++;
            } else if (temp[i - start].compareTo(temp[j - start]) < 0) {//说明左边的数比右边的数小，将左边的数 赋值到array的指定位置
                array[k] = temp[i - start];
                i++;
            } else {
                array[k] = temp[j - start];
                j++;
            }
        }
    }

    //两个有序的数组  合并为一个有序的数组
    private static void mergeArray() {
        int[] arr1 = {1, 4, 5, 9};
        int[] arr2 = {2, 6, 7, 8};
        int[] merge = new int[arr1.length + arr2.length];
        int i = 0, j = 0;
        int index = 0;
        int temp = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                temp = arr1[i];
                i++;
            } else {
                temp = arr2[j];
                j++;
            }
            merge[index] = temp;
            index++;
        }
        while (i < arr1.length) {
            merge[index] = arr1[i++];
            index++;
        }
        while (j < arr2.length) {
            merge[index] = arr2[j++];
            index++;
        }
        TestUtil.printArray("测试：", merge);
    }

    private static void testMergeArray() {
        int[] array = {1, 4, 5, 9, 2, 6, 7, 8};
        int r = array.length - 1;
        mergeArray(array, 0, r / 2, r);
    }

    //一个数组的前后两部分都是有序的，合并前后两部分之后数组保持有序状态。
    private static void mergeArray(int[] array, int start, int mid, int end) {
        //复制 array数组中 从start 到 end 位置的数组。注意这里，不一定是0-length。也有可能是中间段
        int[] temp = Arrays.copyOfRange(array, start, end + 1);
        int i = start; //左半部分索引
        int j = mid + 1;//右半部分索引
        for (int k = start; k <= end; k++) {
            //我们这里的操作是以 temp数组(临时)空间作为比较 然后去重新复制array数组中对应位置的元素
            if (i > mid) {//说明左半部分已经处理完毕，直接将右半部分剩余的放进去即可
                array[k] = temp[j - start];
                j++;
            } else if (j > end) {//说明右半部分已经处理完毕，直接将左半部分剩余的放进去即可
                array[k] = temp[i - start];
                i++;
            } else if (temp[i - start] < temp[j - start]) {//说明左边的数比右边的数小，将左边的数 赋值到array的指定位置
                array[k] = temp[i - start];
                i++;
            } else {
                array[k] = temp[j - start];
                j++;
            }
        }
        TestUtil.printArray("测试合并：", array);
    }
}
