package com.xp.java.leetcode.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @类描述：Leetcode76
 * @创建人：Wangxiaopan
 * @创建时间：2023/3/26 0026 15:42
 * @修改人：
 * @修改时间：2023/3/26 0026 15:42
 * @修改备注：
 */
public class Solution_0076 {

    //给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""

    //示例 1：
    //输入：s = "ADOBECODEBANC", t = "ABC"
    //输出："BANC"
    //解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。

    private static HashMap<Character, Integer> maxMap = new HashMap<>();

    public static String minWindow(String s, String t) {
        ArrayList<String> conStrList = new ArrayList<>();
        int tLength = t.length() - 1;
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            tMap.put(c, 0);
            if (maxMap.containsKey(c)) {
                maxMap.put(c, maxMap.get(c) + 1);
            } else {
                maxMap.put(c, 1);
            }
        }
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = i;
            Character c = s.charAt(i);
            if (tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c) + 1);
            }
            if ((right - left) < tLength) {
                continue;
            } else {
                while (right - left >= tLength) {
                    System.out.println("subStr = " + s.substring(left, right + 1));
                    if (isContain(tMap)) {
                        System.out.println("conStr = " + s.substring(left, right + 1));
                        conStrList.add(s.substring(left, right + 1));
                        Character leftC = s.charAt(left);
                        if (tMap.containsKey(leftC)) {
                            tMap.put(leftC, tMap.get(leftC) - 1);
                        }
                        left++;
                    } else {
                        break;
                    }
                }
            }
        }
        return conStrList.size() == 0 ? "" : conStrList.get(conStrList.size() - 1);
    }

    //对于存在重复字母这个判断就有问题  需要记录字母个数
    public static boolean isContain(HashMap<Character, Integer> map) {
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Character c = (Character) it.next();
            if (map.get(c) < maxMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    //采用滑动窗口的思想
    public String minWindow1(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放左边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    public static void main(String[] args) {
//        System.out.println("最小子串 = "+minWindow("adobecodebanc","abc"));
//        System.out.println("最小子串 = "+minWindow("a","a"));
//        System.out.println("最小子串 = "+minWindow("a","aa"));
//        System.out.println("最小子串 = "+minWindow("bbaa","aba"));
//        System.out.println("最小子串 = "+minWindow("acbbaca","aba"));
        System.out.println("最小子串 = " + minWindow("ab", "a"));
    }
}
