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
        for (int i = 31; i >= 0; i--) {
            System.out.println(n >>> i & 1);
        }
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

    public static void get1CountWei(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        System.out.println("countW = " + count);
    }

    public static int maxSubSum(int[] array) {
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            int thisSum = 0;
            for (int j = i; j < array.length; j++) {
                thisSum += array[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int recoverNum(int n) {
        int converNum = 0;
        while (n > 0) {
            int temp = n % 10;
            converNum = converNum * 10 + temp;
            n = n / 10;
        }
        return converNum;
    }

    //找出能被n整除的数，并且该数只能是0，1组成  穷举法
    public static void findModGotOnly0101(int n) {
        int i = 1;
        boolean isFound = false;

        while (!isFound) {
            String temp = Integer.toBinaryString(i++);
            int num = Integer.valueOf(temp);

            if ((num % n) == 0) {
                isFound = true;
                System.out.println(num);
                break;
            }

            if (num > (Integer.MAX_VALUE >> 1)) {
                System.out.println("specified number not find...");
                break;
            }
        }
    }

    //找出能被n整除的数，并且该数只能是1组成 穷举法
    public static void findModGotOnly1111(int n) {
        int i = 2;
        boolean isFound = false;

        while (!isFound) {
            int temp = i - 1;
            int binary = Integer.valueOf(Integer.toBinaryString(temp));
            if ((binary % n) == 0) {
                isFound = true;
                System.out.println(binary);
                break;
            }
            i = i << 1;

            if (1 > (Integer.MAX_VALUE >> 1)) {
                System.out.println("specified number not find...");
                break;
            }
        }
    }

    //一个大小为n的数组，数的范围是0->n-1,数组中有不确定的重复元素，找出至少一个重复元素，空间O1,时间On
    //数组元素大小确定，那么索引位置放该索引对应的数字，然后在数组内做交换，用一个变量做标记，
    private static void reapteNum(int[] a) {
        for (int i = 0; i < a.length; i++) {
            while (a[i] != i) {
                if (a[i] == a[a[i]]) {
                    System.out.print(a[i]);
                    return;
                } else {
                    int temp = a[i];
                    a[i] = a[a[i]];
                    a[temp] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
//        binaryToDecimal(17);
//        binaryToDecimal1(10);
        get1CountDigui(8);
        get1Count(8);
        get1CountWei(8);
//        System.out.println("totalCount = " + get1CountDigui(17));
        int[] array = {1, 2, 3, 4, 5, -5};
//        System.out.println("maxSum = " + maxSubSum(array));
//        System.out.println("converNum = " + recoverNum(156798));
//        findModGotOnly0101(7);
//        findModGotOnly1111(7);

    }
}
