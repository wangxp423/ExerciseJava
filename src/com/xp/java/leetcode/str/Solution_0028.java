package com.xp.java.leetcode.str;

/**
 * @类描述：Leetcode28 实现strStr()
 * @创建人：Wangxiaopan
 * @创建时间：2018/11/6 0006 11:48
 * @修改人：
 * @修改时间：2018/11/6 0006 11:48
 * @修改备注：
 */
public class Solution_0028 {
    //因为要判断needle是否在haystack 我们可以生成一个长度为needle长度的滑块在haystack中移动
    //时间复杂度为O(n)
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            String temp = haystack.substring(i, i + n);
            if (temp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "pi";
        System.out.println(strStr(haystack, needle));
    }
}
