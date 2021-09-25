package com.xp.java.algorithms.sort;

import com.xp.java.util.TestUtil;

/**
 * @类描述：快速排序
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/15 0015 9:44
 * @修改人：
 * @修改时间：2018/8/15 0015 9:44
 * @修改备注：
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {7, 4, 0, 9, 6, 1, 8, 10, 18, 2};
        quickSort(array, 0, array.length - 1);
        TestUtil.printArray("快速排序：", array);
    }

    public static void sort(Comparable[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(Comparable[] array, int start, int end) {
        if (start > end) return;
        int left = start;
        int right = end;
        Comparable mark = array[start];
        while (left < right) {
            while (left < right && array[right].compareTo(mark) > 0) {
                right--;
            }
            while (left < right && array[left].compareTo(mark) <= 0) {
                left++;
            }
            if (left < right) {
                Comparable temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        Comparable temp = array[start];
        array[start] = array[left];
        array[left] = temp;
        quickSort(array, start, left - 1);
        quickSort(array, left + 1, end);

    }


    private static void quickSort(int[] array, int start, int end) {
        //1，递归终止条件
        if (start > end) return;
        //2,创建标志位 和 索引
        int left = start;
        int right = end;
        int mark = array[start];//可以随机选，一般选择第一个
        while (left < right) {
            //从右到左 找小于mark的数字,这里为什么要先从右到左找呢。因为右边都是大于的数
            // 先从右到左这时候最后找到的按个数肯定是小于mark的，然后跟mark交换保障数组是有序的。
            while (left < right && array[right] > mark) {
                right--;
            }
            //从左到右 找大于mark的数字
            while (left < right && array[left] <= mark) {
                left++;
            }
            //交换 left 和 right位置
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        //交换 mark 和 找到的中间位置元素
        int temp = array[start];
        array[start] = array[left];
        array[left] = temp;
        quickSort(array, start, left - 1);
        quickSort(array, left + 1, end);

    }

}
