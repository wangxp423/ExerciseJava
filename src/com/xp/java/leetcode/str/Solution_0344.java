package com.xp.java.leetcode.str;

/**
 * @类描述：leetcode344 反转字符串
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/12 0012 14:43
 * @修改人：
 * @修改时间：2018/9/12 0012 14:43
 * @修改备注：
 */
public class Solution_0344 {
    public static String reverseString(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            builder.append(c);
        }
        return builder.toString();
    }

    public static String reverseString1(String s) {
        String result = "";
        char[] ch = s.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            result += ch[i];
        }
        return result;
    }

    public static String reverseString2(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    public static String reverseString3(String s) {
        char[] ch = s.toCharArray();
        int halfLength = s.length() / 2;
        char temp;
        for (int i = 0; i < halfLength; i++) {
            temp = ch[s.length() - 1 - i];
            ch[s.length() - 1 - i] = ch[i];
            ch[i] = temp;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(reverseString(s));
    }
}
