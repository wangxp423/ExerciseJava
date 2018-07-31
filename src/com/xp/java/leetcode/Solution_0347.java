package com.xp.java.leetcode;

import java.util.*;

/**
 * @类描述：Leetcode 347 前k个高频元素
 * 这个题 在包heap 下的两个Solution还有不同的解法，大致思路是一样的
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/26 0026 15:42
 * @修改人：
 * @修改时间：2018/7/26 0026 15:42
 * @修改备注：
 */
public class Solution_0347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> sort = new ArrayList<>(map.entrySet());
        Collections.sort(sort, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < k; i++) {
            list.add(sort.get(i).getKey());
        }
        return list;
    }

}
