package com.xp.java.leetcode.array;

/**
 * @类描述：Leetcode4 寻找两个正序数组的中位数
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/27 0027 15:21
 * @修改人：
 * @修改时间：2018/7/27 0027 15:21
 * @修改备注：
 */
public class Solution_0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
        if (totalLength % 2 == 0) {
            return (((double) merge[totalLength / 2] + (double) merge[totalLength / 2 - 1])) / 2;
        } else {
            return merge[totalLength / 2];
        }
    }
}
