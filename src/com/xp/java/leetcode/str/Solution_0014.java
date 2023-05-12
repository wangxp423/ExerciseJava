package com.xp.java.leetcode.str;

/**
 * @类描述：LeetCode14 公共前缀
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/29 0029 9:36
 * @修改人：
 * @修改时间：2018/8/29 0029 9:36
 * @修改备注：
 */
public class Solution_0014 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String mark = strs[0];
        for (int i = 0; i < mark.length(); i++) {
            String temp = mark.substring(0, i + 1);
            if (!isContains(strs, temp)) {
                return temp.substring(0, temp.length() - 1);
            }
        }
        return mark;
    }

    private static boolean isContains(String[] strs, String mark) {
        //这个写法调用了系统API不是很好，后面在做优化 直接用charAt 对比
        for (int j = 0; j < strs.length; j++) {
            String word = strs[j];
            if (!word.startsWith(mark)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog", "racecar", "car"};
        String[] strs2 = {"a", "b"};
        System.out.println(longestCommonPrefix(strs2));
    }
}
