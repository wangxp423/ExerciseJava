package com.xp.java.datastructures.heap;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @类描述：LeetCode 347题  前K个高频元素
 * 在包leetcode下的 347也有这个题的解答。另一种思路
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/31 0031 10:29
 * @修改人：
 * @修改时间：2018/7/31 0031 10:29
 * @修改备注：
 */
public class Solution {
    //这里我们用我们自己实现的优先队列来实现
    //当然我们也可以使用java自带的优先队列来实现,Java自带的优先队列宽展的更好
    private class Freq implements Comparable<Freq> {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            return o.freq - this.freq; //从小到大排
        }
    }

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
        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (queue.getSize() < k) {
                queue.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > queue.getFront().freq) { //从小到大排 这里才能有效
                queue.dequeue();
                queue.enqueue(new Freq(key, map.get(key)));
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            list.add(queue.dequeue().e);
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1};
        int k = 2;
        System.out.println((new Solution()).topKFrequent(nums, k));
    }
}
