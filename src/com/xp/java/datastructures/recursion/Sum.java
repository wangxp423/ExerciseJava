package com.xp.java.datastructures.recursion;

/**
 * @类描述：用递归求区间数字之和
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/24 0024 17:31
 * @修改人：
 * @修改时间：2018/7/24 0024 17:31
 * @修改备注：
 */
public class Sum {
    public static int sum(int[] sums) {
        return sum(sums, 0);
    }

    public static int sum(int[] sums, int l) {
        if (l == sums.length) return 0;
        return sums[l] + sum(sums, l + 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }
}
