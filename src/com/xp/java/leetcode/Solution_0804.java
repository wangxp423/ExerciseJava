package com.xp.java.leetcode;

import java.util.TreeSet;

/**
 * @类描述：leetcode 804题
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/25 0025 10:26
 * @修改人：
 * @修改时间：2018/7/25 0025 10:26
 * @修改备注：
 */
public class Solution_0804 {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] mos = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> set = new TreeSet<>();
        for (String s : words) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                builder.append(mos[c - 'a']);
            }
            set.add(builder.toString());
        }
        return set.size();
    }
}
