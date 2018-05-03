package com.xp.java.sort;

import java.util.Arrays;

/**
 * Created by Wang on 2018/5/2 0002.
 * 希尔排序
 */
public class ShellSort {
    public static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType[] array) {
        int j;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                AnyType temp = array[i];
                for (j = i; j >= gap && temp.compareTo(array[j - gap]) < 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
//            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{34, 8, 64, 51, 32, 21};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
