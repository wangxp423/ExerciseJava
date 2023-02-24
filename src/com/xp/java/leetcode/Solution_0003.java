package com.xp.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @类描述：Leetcode 第三题 无重复字符的最长子串
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/27 0027 15:21
 * @修改人：
 * @修改时间：2018/7/27 0027 15:21
 * @修改备注：
 */
public class Solution_0003 {
    public static int longestSubstringLength(String s) {
        int n = s.length(), ans = 0, i = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            Character c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(map.get(c), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(c, j + 1);
        }
        return ans;
    }

    public static String longestSubString(String s) {
        int length = s.length();
        int start = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            max = Math.max(max, i - start + 1);
            map.put(c, i + 1); //+1是因为，如果重复，改值为下一个起点的位置
        }
        return s.substring(start, start + max);
    }


    public static void main(String[] args) {
        String s = "abccabcd";
        System.out.println(longestSubstringLength(s));
        System.out.println(longestSubString(s));
        Map<Character, Integer> map = new HashMap<>(3);
    }
}
