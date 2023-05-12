package com.xp.java.leetcode.array;

import com.xp.java.util.TestUtil;

/**
 * @类描述：LeetCode27 移除元素
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
        TestUtil.printArray("removeElement :", array);
        int[] array1 = {2, 2, 2, 2, 3, 0, 4, 2};
        System.out.println("Size = " + removeElement1(array1, 2));
        TestUtil.printArray("removeElement1 :", array1);
    }

    public static int removeElement(int[] nums, int val) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[size] = nums[i];
                size++;
            }
        }
        return size;
    }

    //相比于上一种 稍微优化了一点。
    public static int removeElement1(int[] nums, int val) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (size != i) {
                    nums[size] = nums[i];
                }
                size++;
            }
        }
        return size;
    }
}
