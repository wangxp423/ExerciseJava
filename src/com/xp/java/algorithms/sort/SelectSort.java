package com.xp.java.algorithms.sort;

import com.xp.java.util.SortTestHelper;
import com.xp.java.util.TestUtil;

/**
 * @类描述：选择排序 1, 外层遍历一遍，每次遍历我们默认当前位置(i)为剩余元素中的最小值的位置。
 * 2，默认最小值所在的位置即为外层遍历位置，然后与剩余元素比较，如果小于最小元素，记录最小元素的索引，然后继续比较。
 * 3，一轮比较下来我们就回找到最小元素，然后跟外层i的位置进行交换，将该轮的最小值放在该放的位置。
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/13 0013 15:36
 * @修改人：
 * @修改时间：2018/8/13 0013 15:36
 * @修改备注：
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        TestUtil.printArray("选择排序：", selectSort(array));
        testComparable();
        testMoreData();
        testSort();
    }


    private static void testComparable() {
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        sort(b);
        SortTestHelper.printArray(b);
    }

    private static void testMoreData() {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        sort(arr);
        SortTestHelper.printArray(arr);
    }

    private static void testSort() {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.xp.java.algorithms.sort.SelectSort", arr);
    }

    //从小到大的排序
    private static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    public static void sort(Comparable[] arr) {
        //比较其他的类，只需要实现Comparable接口即可。
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Comparable temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
