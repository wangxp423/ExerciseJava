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
    public int lengthOfLongestSubstring(String s) {
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

    public static void main(String[] args) {
        String s = "abccabcd";
        System.out.println(new Solution_0003().lengthOfLongestSubstring(s));
    }
}
