package com.xp.java.leetcode;

/**
 * @类描述：LeetCode7 翻转数字
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

    //打印区间回文数
    public static void printReverseNum() {
        StringBuilder builder = new StringBuilder();
        for (int i = 10; i < 1000; i++) {
            String num = String.valueOf(i);
            int left = 0;
            int right = num.length() - 1;
            while (left < right && (num.charAt(left) == num.charAt(right))) {
                left++;
                right--;
                if (left >= right) {
                    builder.append(num).append(",");
                }
            }
        }
        System.out.println("区间回文数 = " + builder.toString());
    }

    public static void main(String[] args) {
        System.out.println("反转 = " + reverse(234));
        printReverseNum();
    }
}
