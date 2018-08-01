package com.xp.java.leetcode;

/**
 * @类描述：Leetcode 303题 区域和检索 - 数组不可变
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/1 0001 15:00
 * @修改人：
 * @修改时间：2018/8/1 0001 15:00
 * @修改备注：
 */
public class Solution_0303 {
    public static class NumArray {
        public int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            //这个地方的i之所以不+1 这个看题目给到的例子结果就知道了
            return sum[j + 1] - sum[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(nums);
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < array.sum.length; i++) {
            builder.append(array.sum[i]);
            if (i != array.sum.length - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        System.out.println(builder.toString());
        System.out.println(array.sumRange(0, 2));
        System.out.println(array.sumRange(2, 5));
        System.out.println(array.sumRange(0, 5));
    }
}
