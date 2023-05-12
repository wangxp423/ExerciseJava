package com.xp.java.leetcode.array;

/**
 * @类描述：Leetcode307 区域和检索 - 数组可修改
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/1 0001 15:00
 * @修改人：
 * @修改时间：2018/8/1 0001 15:00
 * @修改备注：
 */
public class Solution_0307 {
    //这个题和303增加了一个修改数组数据的操作
    public static class NumArray {
        public int[] data;
        public int[] sum;

        public NumArray(int[] nums) {
            //保存原始数据
            data = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }

            //sum数组用来记录远数据的前N个元素的和
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        public void update(int i, int val) {
            data[i] = val;
            sum[0] = 0;
            for (int j = 1; j < sum.length; j++) {
                sum[j] = sum[j - 1] + data[j - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }


    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(nums);
        printArray(array.data);
        printArray(array.sum);
        System.out.println(array.sumRange(0, 2));
        array.update(1, 2);
        printArray(array.data);
        printArray(array.sum);
        System.out.println(array.sumRange(0, 2));
    }

    private static void printArray(int[] array) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i != array.length - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}
