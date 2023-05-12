package com.xp.java.leetcode.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类描述：Leetcode438 这个题结合76提 有点类似
 * 不一样的地方在于 这个异位词是连续的，我们可以用一个连续的固定滑块去便利一遍
 * @创建人：Wangxiaopan
 * @创建时间：2023/3/26 0026 15:42
 * @修改人：
 * @修改时间：2023/3/26 0026 15:42
 * @修改备注：
 */
public class Solution_0438 {

    /**
     * 示例1:
     * <p>
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     * <p>
     * 示例 2:
     * <p>
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexs = new ArrayList<>();
        int count = p.length();
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            chars.put(p.charAt(i), 1);
        }
        int right = p.length() - 1;
        int left = 0;
        for (int i = 0; i < right; i++) {
            Character c = s.charAt(i);
            if (!chars.containsKey(c)) {
                count--;
            }
        }
        if (count == p.length()) {
            indexs.add(left);
        }
        while (right < s.length() - 1) {
            left++;
            right++;
            Character leftC = s.charAt(left - 1);
            if (chars.containsKey(leftC)) {
                if (chars.get(leftC) == 1) {
                    count--;
                }
                chars.put(leftC, chars.get(leftC) - 1);
            }
            Character rightC = s.charAt(right);
            if (chars.containsKey(rightC)) {
                if (chars.get(rightC) == 0) {
                    count++;
                }
                chars.put(rightC, chars.get(rightC) + 1);
            }
            System.out.println(s.substring(left, right + 1) + "  " + count);
            if (count == p.length()) {
                indexs.add(left);
            }
        }
        return indexs;
    }

    public static void main(String[] args) {
//        System.out.println(findAnagrams("cbaebabacd","abc").toString());
        System.out.println(findAnagrams("abab", "ab").toString());
    }
}
