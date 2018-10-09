package com.xp.java.leetcode;

/**
 * @类描述：Leetcode53题 最大子序和
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/8 0008 14:41
 * @修改人：
 * @修改时间：2018/10/8 0008 14:41
 * @修改备注：
 */
public class Solution_0053 {
    //这是一个O(n²)复杂度的一个写法。当然初始值可能为0的时候会有问题。提交Leetcode也有问题，但是思路是对的。
    public static int maxSubArray(int[] nums) {
        int max = 0;
        int sum = 0;
        int tempMax = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            tempMax = sum;
            for (int j = i + 1; j < nums.length; j++) {
                int subSum = sum + nums[j];
                if (subSum > tempMax) {
                    tempMax = subSum;
                }
                sum = subSum;
            }
            if (max < tempMax) {
                max = tempMax;
            }
        }
        return max;
    }

    //通过前几个数的和与最新要加入的数进行比较，如果最新数大于和。说明最大值肯定是在最新数后面开始的。
    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("result = " + maxSubArray(array));
        System.out.println("result1 = " + maxSubArray1(array));
    }
}
