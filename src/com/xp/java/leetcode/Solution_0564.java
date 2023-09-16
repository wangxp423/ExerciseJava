package com.xp.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * leetcode564 寻找最近的回文数
 */
public class Solution_0564 {
    public static String nearestPalindromic(String n) {
        long selfNumber = Long.parseLong(n), ans = -1;
        List<Long> candidates = getCandidates(n);
        for (long candidate : candidates) {
            System.out.println("回文数 = " + candidate);
            if (candidate != selfNumber) {
                if (ans == -1 ||
                        Math.abs(candidate - selfNumber) < Math.abs(ans - selfNumber) ||
                        Math.abs(candidate - selfNumber) == Math.abs(ans - selfNumber) && candidate < ans) {
                    ans = candidate;
                }
            }
        }
        return Long.toString(ans);
    }

    public static List<Long> getCandidates(String n) {
        int len = n.length();
        List<Long> candidates = new ArrayList<Long>() {{
            add((long) Math.pow(10, len - 1) - 1);
            add((long) Math.pow(10, len) + 1);
        }};
        long selfPrefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = selfPrefix - 1; i <= selfPrefix + 1; i++) {
            StringBuffer sb = new StringBuffer();
            String prefix = String.valueOf(i);
            sb.append(prefix);
            StringBuffer suffix = new StringBuffer(prefix).reverse();
            sb.append(suffix.substring(len & 1));
            String candidate = sb.toString();
            try {
                candidates.add(Long.parseLong(candidate));
            } catch (NumberFormatException ex) {
                continue;
            }
        }
        return candidates;
    }

    // x & 1 用来判断奇偶数
    public static void evenNum() {
        int[] array = new int[]{3, 4, 5, 6, 7};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] & 1);
        }
    }

    public static String printReverseNum(String inputStr) {
        long inputNum = Long.parseLong(inputStr);
        long result = -1;
        List<Long> nums = reverseNums(inputStr);
        for (long num : nums) {
            System.out.println("回文数 = " + num);
            if (num != inputNum) {
                if (result == -1 ||
                        Math.abs(num - inputNum) < Math.abs(result - inputNum) ||
                        Math.abs(num - inputNum) == Math.abs(result - inputNum) && num < result) {
                    result = num;
                }
            }
        }
        System.out.println("最近回文数 = " + String.valueOf(result));
        return String.valueOf(result);
    }

    public static List<Long> reverseNums(String inputNum) {
        int strLength = inputNum.length();
        int halfLength = (strLength + 1) / 2;
        List<Long> nums = new ArrayList<>();
        nums.add((long) Math.pow(10, halfLength - 1) - 1);
        nums.add((long) Math.pow(10, halfLength) + 1);
        long leftNum = Long.parseLong(inputNum.substring(0, halfLength));
        for (long i = leftNum - 1; i <= leftNum + 1; i++) {
            StringBuffer left = new StringBuffer();
            String leftStr = String.valueOf(i);
            left.append(leftStr);
            StringBuffer rightNum = new StringBuffer(leftStr).reverse();
            left.append(rightNum.substring(strLength & 1));
            nums.add(Long.parseLong(left.toString()));
        }
        return nums;
    }

    public static void main(String[] args) {
//        printRecentlyReverseNum(12);
//        System.out.println(nearestPalindromic("8"));
        System.out.println(printReverseNum("120"));
        evenNum();
    }

}
