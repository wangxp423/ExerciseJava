package com.xp.java;

/**
 * Created by Wang on 2018/1/15 0015.
 */
public class TextMain {
    public static void binaryToDecimal(int n) {
        String str = "";
        while (n != 0) {
            str = n % 2 + str;
            n = n / 2;
        }
        System.out.println(str);
    }

    public static void binaryToDecimal1(int n) {
        for (int i = 31; i >= 0; i--)
            System.out.print(n >>> i & 1);
    }

    public static int get1CountDigui(int n) {
        int count = 0;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (n % 2 != 0) {
            count = get1CountDigui(n / 2) + 1;
        } else {
            count = get1CountDigui(n/2);
        }
        System.out.println("countD = " + count);
        return count;
    }

    public static int get1Count(int n)  {
        int count = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                count++;
            }
            n = n / 2;
        }
        System.out.println("count = " + count);
        return count;
    }

    public static int maxSubSum(int[] array){
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            int thisSum = 0;
            for (int j = i; j < array.length; j++) {
                thisSum += array[j];
                if (thisSum > maxSum){
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
//        binaryToDecimal(17);
//        binaryToDecimal1(10);
//        binaryToDecimal2(9);
//        get1Count(11);
//        System.out.println("totalCount = " + get1CountDigui(17));
        int[] array = {1,2,3,4,5};
        System.out.println("maxSum = " + maxSubSum(array));
    }
}
