package com.xp.java.leetcode.str;

/**
 * @类描述：Leetcode5 最长回文子串
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/27 0027 15:21
 * @修改人：
 * @修改时间：2018/7/27 0027 15:21
 * @修改备注：
 */
public class Solution_0005 {
    /**
     * 示例 1：
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * <p>
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * 提示：
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     */
    public static String longestPalindrome(String s) {
        int start = 0;
        int size = 0;
        for (int i = 0; i < s.length() - 3; i++) {
            int left = i;
            int right = i + 2;
            if (s.charAt(left) == s.charAt(right)) {
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                int tempSize = right - left - 1;
                if (size < tempSize) {
                    size = tempSize;
                    start = left + 1;
                    ;
                }
                System.out.println(s.substring(start, start + size));
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            int left = i;
            int right = i + 1;
            if (s.charAt(left) == s.charAt(right)) {
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                int tempSize = right - left - 1;
                if (size < tempSize) {
                    size = tempSize;
                    start = left + 1;
                    ;
                }
                System.out.println(s.substring(start, start + size));
            }
        }

        return s.substring(start, start + size);
    }

    public static void main(String[] args) {
        System.out.println("最长回文串 = " + longestPalindrome("babad"));
//        System.out.println("最长回文串 = " + longestPalindrome("cbbd"));
    }
}
