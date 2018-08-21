package com.xp.java.leetcode;

import com.xp.java.util.TestUtil;

/**
 * @类描述：LeetCode 27题 移除元素
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/21 0021 10:58
 * @修改人：
 * @修改时间：2018/8/21 0021 10:58
 * @修改备注：
 */
public class Solution_0027 {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println("Size = " + removeElement(array, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[size] = nums[i];
                size++;
            }
        }
        TestUtil.printArray("LeetCode27 :", nums);
        return size;
    }
}
