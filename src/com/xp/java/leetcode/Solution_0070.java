package com.xp.java.leetcode;

/**
 * leetcode70 爬楼梯问题
 */
public class Solution_0070 {
    public static int climbStairs(int n) {
        return upStairs(n);
    }


    public static int upStairs(int n) {
        if (n == 1 || n == 2) { //已知第一阶和第二阶的上法
            return n;
        }

        return upStairs(n - 1) + upStairs(n - 2); //n阶楼梯的上法等于 n - 1和 n - 2阶楼梯上法的和
    }

    public static void main(String[] args) {
        System.out.println("走法：" + climbStairs(20));
    }
}
