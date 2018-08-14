package com.xp.java.util;

/**
 * @类描述：打印工具类
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/6 0006 15:44
 * @修改人：
 * @修改时间：2018/8/6 0006 15:44
 * @修改备注：
 */
public class TestUtil {
    public static void printArray(String name, int[] array) {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append("[");
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i != array.length - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    //另外一种交换方式
    public static void swap1(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }
}
