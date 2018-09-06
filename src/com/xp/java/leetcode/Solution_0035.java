package com.xp.java.leetcode;

/**
 * @类描述：LeetCode 第35题 搜索插入位置
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/6 0006 9:35
 * @修改人：
 * @修改时间：2018/9/6 0006 9:35
 * @修改备注：
 */
public class Solution_0035 {
    //这个题就是一个二分查找 只不多在没有找到的情况下 多了一步插入计算位置
    //具体为什么返回start 就可以，断点调试两次就清楚明白了。
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start <= end) {
            if (start == nums.length) return start;
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int index = searchInsert(nums, 0);
        System.out.println("index = " + index);
    }
}
