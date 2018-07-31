package com.xp.java.datastructures.heap;

import java.util.*;
import java.util.PriorityQueue;

/**
 * @类描述：LeetCode 347题  前K个高频元素
 * 在包leetcode下的 347也有这个题的解答。另一种思路
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/31 0031 10:29
 * @修改人：
 * @修改时间：2018/7/31 0031 10:29
 * @修改备注：
 */
public class Solution1 {
    //使用java自带的优先队列来实现,Java自带的优先队列宽展的更好
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2); //从小到大排
            }
        });
        for (int key : map.keySet()) {
//            queue.add(key);
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) { //从小到大排 这里才能有效
                queue.remove();
                queue.add(key);
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            list.add(queue.remove());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
//        int[] nums = {1, 1, 1, 2, 2,2,2,2, 3,3,3,3,3,3,3,1,1,1,1,1,1};
        int k = 2;
        System.out.println((new Solution1()).topKFrequent(nums, k));
    }
}
