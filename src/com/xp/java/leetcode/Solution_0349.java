package com.xp.java.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @类描述：Leetcode 349 两个数组的交集1
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/26 0026 15:42
 * @修改人：
 * @修改时间：2018/7/26 0026 15:42
 * @修改备注：
 */
public class Solution_0349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums2.length; j++) {
            int num = nums2[j];
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }
        int[] intersect = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            intersect[k] = list.get(k);
        }
        return intersect;
    }
}
