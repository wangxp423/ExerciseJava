package com.xp.java.leetcode.array;


/**
 * @类描述：LeetCode136 只出现一次的数字
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/21 0021 11:13
 * @修改人：
 * @修改时间：2018/9/21 0021 11:13
 * @修改备注：
 */
public class Solution_0136 {
    //时间复杂度 O(n²)
    public static int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isEquals = false;
            int num = nums[i];
            int rightIndex = nums.length - 1 - i;
            for (int j = nums.length - 1; j > i; j--) {
                if (num == nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[rightIndex];
                    nums[rightIndex] = temp;
                    isEquals = true;
                } else {
                    continue;
                }
            }
            if (!isEquals) return num;
        }
        return -1;
    }

    //O(n)的复杂度  按位异或 我们知道两个相同的数  按位异或以后 是 00000000。
    // 所以所有的数去异或值以后 最后那个数肯定是不同的那个
    public static int singleNumber3(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] ^ nums[i - 1];
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("result = " + singleNumber(nums));
        System.out.println("result3 = " + singleNumber3(nums));
    }
}
