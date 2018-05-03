package com.xp.java.sort;

import java.util.Arrays;

/**
 * Created by Wang on 2018/5/2 0002.
 * 插入排序
 */
public class InserSort {
    public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] array) {
        int i;
        for (int j = 1; j < array.length; j++) {
            AnyType temp = array[j];
            for (i = j; i > 0 && temp.compareTo(array[i - 1]) < 0; i--) {
                array[i] = array[i - 1];
            }
            array[i] = temp;
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{34, 8, 64, 51, 32, 21};
        insertionSort(array);
    }
}
