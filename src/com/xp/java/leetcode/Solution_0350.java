package com.xp.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @类描述：Leetcode 350 两个数组的交集
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/26 0026 15:42
 * @修改人：
 * @修改时间：2018/7/26 0026 15:42
 * @修改备注：
 */
public class Solution_0350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums2.length; j++) {
            int key = nums2[j];
            if (map.containsKey(key)) {
                list.add(key);
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
            }

        }
        int[] intersect = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            intersect[k] = list.get(k);
        }
        return intersect;
    }
}
