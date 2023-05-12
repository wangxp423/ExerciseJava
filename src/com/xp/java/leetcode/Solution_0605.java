package com.xp.java.leetcode;

/**
 * leetcode605 种花问题
 * 间隔一个种才能成活
 */
public class Solution_0605 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0;
        for (int i = 0; i < flowerbed.length; ) {
            if (flowerbed[i] == 1) {
                i = i + 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                num++;
                i = i + 2;
            } else {
                i = i + 3;
            }
        }
        System.out.println("可种花数量 = " + num);
        return num >= n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[]{0, 1, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 1));
        System.out.println(canPlaceFlowers(new int[]{0}, 1));
        System.out.println(canPlaceFlowers(new int[]{0, 1}, 1));
    }
}
