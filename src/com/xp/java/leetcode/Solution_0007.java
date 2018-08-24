package com.xp.java.leetcode;

/**
 * @类描述：LeetCode 7题 翻转数字
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/24 0024 17:10
 * @修改人：
 * @修改时间：2018/8/24 0024 17:10
 * @修改备注：
 */
public class Solution_0007 {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            //下面是对越界的判断
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println("翻转 = " + reverse(234));
    }
}
