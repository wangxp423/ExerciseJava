package com.xp.java.leetcode.array;

import com.xp.java.util.TestUtil;

/**
 * @类描述：Leetcode283 移动零
 * 这个题 和 LeetCode 27题很相似 差一步补位而已
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/21 0021 11:26
 * @修改人：
 * @修改时间：2018/8/21 0021 11:26
 * @修改备注：
 */
public class Solution_0283 {
    //    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//    示例:
//    输入: [0,1,0,3,12]
//    输出: [1,3,12,0,0]

    public static void moveZeroes(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[size] = nums[i];
                size++;
            }
        }
        while (size < nums.length) {
            nums[size] = 0;
            size++;
        }
    }

    //通过交换非0和0的位置
    public static void moveZeroes1(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (size == i) {
                    size++;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[size];
                    nums[size] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 0, 3, 12};
        moveZeroes(array);
        TestUtil.printArray("moveZeroes = ", array);
        moveZeroes1(array);
        TestUtil.printArray("moveZeroes1 = ", array);
    }
}
