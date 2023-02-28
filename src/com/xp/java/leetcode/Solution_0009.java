package com.xp.java.leetcode;

/**
 * 判断一个数是否是回文数
 */
public class Solution_0009 {
    public static boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) {
            return true;
        } else if (x < 0) {
            return false;
        }
        String numStr = String.valueOf(x);
        int left = 0, right = numStr.length() - 1;
        while (left < right && numStr.charAt(left) == numStr.charAt(right)) {
            left++;
            right--;
            if (left >= right) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
