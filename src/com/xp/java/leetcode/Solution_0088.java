package com.xp.java.leetcode;

import com.xp.java.util.TestUtil;

/**
 * @类描述：LeetCode 88题 合并两个有序数组
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/28 0028 15:42
 * @修改人：
 * @修改时间：2018/8/28 0028 15:42
 * @修改备注：
 */
public class Solution_0088 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m < m + n) {
            int insert = nums2[--n]; //这里用--n不好，因为是有序，先插入大的 导致后插入的都要进行比较，这里这么写纯粹为了好看。
            nums1[m++] = insert;
            for (int i = m - 1; i > 0; i--) {
                if (nums1[i] - nums1[i - 1] < 0) {
                    int temp = nums1[i];
                    nums1[i] = nums1[i - 1];
                    nums1[i - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        TestUtil.printArray("合并有序数组：", nums1);
    }
}
