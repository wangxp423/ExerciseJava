package com.xp.java.leetcode;

import com.xp.java.util.TestUtil;

/**
 * @类描述：Leetcode 26题  删除排序数组中的重复项
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/6 0006 15:32
 * @修改人：
 * @修改时间：2018/8/6 0006 15:32
 * @修改备注：
 */
public class Solution_0026 {
    //返回 删除重复数组的长度，并且数组的前几项为不重复的元素
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count]) {
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("length = " + removeDuplicates(nums));
        TestUtil.printArray("打印输出：", nums);
    }
}
