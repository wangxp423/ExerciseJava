package com.xp.java.leetcode;

import com.xp.java.util.TestUtil;

/**
 * @类描述：LeetCode 88题 合并两个有序数组,两个有序数组的中位数
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/28 0028 15:42
 * @修改人：
 * @修改时间：2018/8/28 0028 15:42
 * @修改备注：
 */
public class Solution_0088 {
    //其实对于一个有序数组 用插入排序还是很高校的。当然前提是 后面数组的最小元素大于前面数组的最大元素。
    //这里其实用的是一个插入排序算法原理。
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m < m + n) {
            int insert = nums2[--n]; //这里用--n不好，因为是有序，先插入大的 导致后插入的都要进行比较，这里这么写纯粹为了好看。
            nums1[m++] = insert;
            //插入排序原理
            for (int i = m - 1; i > 0; i--) {
                if (nums1[i] - nums1[i - 1] < 0) {
                    int temp = nums1[i];
                    nums1[i] = nums1[i - 1];
                    nums1[i - 1] = temp;
                }
            }
        }
    }

    //其实对于一个有序数组 用插入排序还是很高校的。当然前提是 后面数组的最小元素不要大于前面数组的最大元素。
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        while (index < n) {
            nums1[m++] = nums2[index];
            index++;
            //插入排序原理
            for (int i = m - 1; i > 0; i--) {
                if (nums1[i] - nums1[i - 1] < 0) {
                    int temp = nums1[i];
                    nums1[i] = nums1[i - 1];
                    nums1[i - 1] = temp;
                }
            }
        }
    }

    //合并两个有序数组
    public static void mergeArray() {
        int[] arr1 = {1, 4, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 7, 8};
        int[] merge = new int[arr1.length + arr2.length];
        int arr1Index = 0, arr2Index = 0;
        int temp = 0, mergeIndex = 0;
        while (arr1Index < arr1.length && arr2Index < arr2.length) {
            if (arr1[arr1Index] < arr2[arr2Index]) {
                temp = arr1[arr1Index];
                arr1Index++;
            } else {
                temp = arr2[arr2Index];
                arr2Index++;
            }
            merge[mergeIndex] = temp;
            mergeIndex++;
        }
        while (arr1Index < arr1.length) {
            merge[mergeIndex] = arr1[arr1Index++];
            mergeIndex++;
        }
        while (arr2Index < arr2.length) {
            merge[mergeIndex] = arr2[arr2Index++];
            mergeIndex++;
        }
        TestUtil.printArray("合并两个有序数组", merge);
    }

    //插入排序合并数组
    private static void mergeArrayInsert() {
        int[] arr1 = {1, 4, 5, 9};
        int[] arr2 = {2, 6, 7, 8};
        int compare = 0;
        int[] merge = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            merge[i] = arr1[i];
        }
        for (int j = arr1.length; j < merge.length; j++) {
            merge[j] = arr2[j - arr1.length];
            for (int k = j; k > 0; k--) {
                if (merge[k] < merge[k - 1]) {
                    int temp = merge[k];
                    merge[k] = merge[k - 1];
                    merge[k - 1] = temp;
                    System.out.println(++compare);
                }
            }
        }
        TestUtil.printArray("插入合并有序数组：", merge);
    }

    // 两个有序数组的中位数 其实只需要取合并后的前半部分就可以了
    //    示例 1:
    //    nums1 = [1, 3]
    //    nums2 = [2]
    //    则中位数是 2.0
    //
    //    示例 2:
    //    nums1 = [1, 2]
    //    nums2 = [3, 4]
    //    则中位数是 (2 + 3)/2 = 2.5
    private static double mergeArrayMiddelNum() {
        int[] nums1 = {1, 4, 5, 0};
        int[] nums2 = {2, 6, 7, 8};
        int totalLength = nums1.length + nums2.length;
        int[] merge = new int[totalLength];
        int leftIndex = 0, rightIndex = 0, temp = 0, mergeIndex = 0;
        while (mergeIndex <= totalLength / 2) {
            if (leftIndex < nums1.length && rightIndex < nums2.length) {
                if (nums1[leftIndex] < nums2[rightIndex]) {
                    temp = nums1[leftIndex];
                    leftIndex++;
                } else {
                    temp = nums2[rightIndex];
                    rightIndex++;
                }
                merge[mergeIndex] = temp;
                mergeIndex++;
            } else if (leftIndex >= nums1.length) {
                merge[mergeIndex] = nums2[rightIndex++];
                mergeIndex++;
            } else {
                merge[mergeIndex] = nums1[leftIndex++];
                mergeIndex++;
            }
        }
        TestUtil.printArray("合并有序数组中位数：", merge);
        if (totalLength % 2 == 0) {
            return (((double) merge[totalLength / 2] + (double) merge[totalLength / 2 - 1])) / 2;
        } else {
            return merge[totalLength / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
//        merge(nums1, 3, nums2, 3);
        merge1(nums1, 3, nums2, 3);
        TestUtil.printArray("合并有序数组：", nums1);
        mergeArray();
        System.out.println("中位数 = " + mergeArrayMiddelNum());
    }
}
