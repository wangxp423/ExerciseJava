package com.xp.java.leetcode;

import java.util.HashMap;

/**
 * @类描述：两数之和
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/27 0027 14:49
 * @修改人：
 * @修改时间：2018/7/27 0027 14:49
 * @修改备注：
 */
public class Solution_0001 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[]{map.get(other), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
