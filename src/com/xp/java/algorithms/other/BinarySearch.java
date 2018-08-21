package com.xp.java.algorithms.other;

/**
 * @类描述：折半查找(前提是一个有序数组)
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/21 0021 10:22
 * @修改人：
 * @修改时间：2018/8/21 0021 10:22
 * @修改备注：
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Index = " + binarySearchIndex(array, 10));
    }

    public static int binarySearchIndex(int[] array, int num) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == num) {
                return mid;
            } else if (array[mid] > num) {
                end = mid - 1;
            } else if (array[mid] < num) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
