package com.xp.java;

import com.xp.java.util.SortTestHelper;
import com.xp.java.util.TestUtil;

import java.util.Arrays;

//一些基础题
public class TextJava {
    /*****************位运算*****************/
    public static void rightOne2Zero(int x) {
        int y = 0;
        y = x & (x - 1);
        System.out.println(y);
    }

    //统计1的位数有几个
    public static void sumOneCount(int x) {
        int count = 0;
        while (x > 0) {
            x = x & (x - 1);
            System.out.println("x = " + x);
            count++;
        }
        System.out.println(count);
    }

    //反转二进制并且得到反转后的结果，如果是32位反转 补齐位数，从32长度循环
    public static void revertBit(int n) {
        String binary = Integer.toBinaryString(n);
        int result = 0;
        for (int i = 0; i < binary.length(); i++) {
            result = (result << 1) + (n & 1);
            n = n >> 1;
        }
        System.out.println(result);
    }

    public static void testMaoPao() {
        int[] maopao = new int[]{7, 5, 3, 2, 1};
        for (int i = 0; i < maopao.length; i++) {
            for (int j = 0; j < maopao.length - i - 1; j++) {
                if (maopao[j + 1] < maopao[j]) {
                    int temp = maopao[j];
                    maopao[j] = maopao[j + 1];
                    maopao[j + 1] = temp;
                }
                TestUtil.printArray("冒泡排序:", maopao);
            }
        }
    }

    public static void selectionSort() {
        int[] array = new int[]{7, 5, 3, 2, 1};
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
            TestUtil.printArray("选择排序:", array);
        }
    }

    public static void insertSort() {
        int[] array = new int[]{7, 5, 3, 2, 1};
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
            TestUtil.printArray("插入排序:", array);
        }
    }

    //给定一个长度为n的字符串比如：abcdefgh,空间负责度为O(n)
    //置顶索引位置将字符串从索引位置前后置换，比如索引3，变换以后的字符串为defghabc
    public static void revertStrings(int start, int end, String[] arrays) {
        if (end > arrays.length - 1) {
            throw new IllegalStateException("超过最大长度限制");
        }
        int middle = (start + end) / 2;
        while (end > middle) {
            String temp = arrays[start];
            arrays[start] = arrays[end];
            arrays[end] = temp;
            start++;
            end--;
        }
        SortTestHelper.printArray(arrays);
    }

    private static int[] array = new int[]{2, 3, 5, 7, 9, 11, 14, 16, 17};

    public static int testSearch(int targetNumber) {
        int left = 0;
        int right = array.length - 1;
        int middle = 0;
        if (left > right) return -1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (targetNumber == array[middle]) {
                return middle;
            } else if (targetNumber > array[middle]) {
                left = middle + 1;
            } else if (targetNumber < array[middle]) {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static int testSearchCircle(int left, int right, int targetNumber) {
        if (left > right) return -1;
        int middle = (left + right) / 2;
        if (targetNumber == array[middle]) {
            return middle;
        } else if (targetNumber > array[middle]) {
            return testSearchCircle(middle + 1, right, targetNumber);
        } else if (targetNumber < array[middle]) {
            return testSearchCircle(left, middle - 1, targetNumber);
        }
        return -1;
    }

    public static void testQuickSort(int[] array, int start, int end) {
        if (start > end) return;
        int left = start;
        int right = end;
        int targetNum = array[start];
        while (left < right) {
            while (left < right && array[right] > targetNum) {
                right--;
            }
            while (left < right && array[left] <= targetNum) {
                left++;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        int temp = array[start];
        array[start] = array[left];
        array[left] = temp;
        testQuickSort(array, start, left - 1);
        testQuickSort(array, left + 1, end);
    }

    private static void mergeArray() {
        int[] arr1 = {1, 4, 5, 9};
        int[] arr2 = {2, 6, 7, 8};
        int compare = 0;
        int[] merge = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int temp = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] > arr2[index2]) {
                temp = arr2[index2];
                index2++;
                System.out.println(++compare);
            } else {
                temp = arr1[index1];
                index1++;
                System.out.println(++compare);
            }
            merge[index] = temp;
            index++;
        }
        while (index1 < arr1.length) {
            merge[index] = arr1[index1++];
            index++;
        }
        while (index2 < arr2.length) {
            merge[index] = arr2[index2++];
            index++;
        }
        TestUtil.printArray("合并有序数组：", merge);
    }

    private static void mergeArrayInsert() {
        int[] arr1 = {1, 4, 5, 9};
        int[] arr2 = {2, 6, 7, 8};
        int compare = 0;
        int[] merge = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            merge[i] = arr1[i];
        }
        for (int j = arr1.length; j < merge.length; j++) {
            merge[j] = arr2[j - arr1.length];
            for (int k = j; k > 0; k--) {
                if (merge[k] < merge[k - 1]) {
                    int temp = merge[k];
                    merge[k] = merge[k - 1];
                    merge[k - 1] = temp;
                    System.out.println(++compare);
                }
            }
        }
        TestUtil.printArray("插入合并有序数组：", merge);
    }

    private static void testMergeArray() {
//        int[] array = {1, 4, 5, 9, 2, 6, 7, 8};
//        int r = array.length - 1;
//        mergeArray(array, 0, r / 2, r);
        int[] array2 = {9, 5, 4, 1, 8, 7, 6, 2};
        mergeSort(array2, 0, array2.length - 1);
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start >= end) return;
        int middle = (start + end) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);
        mergeArray(array, start, middle, end);
    }

    //一个数组的前后两部分都是有序的，合并前后两部分之后数组保持有序状态。
    //归并排序的核心 合并有序数组
    private static void mergeArray(int[] array, int start, int mid, int end) {
        //复制 array数组中 从start 到 end 位置的数组。注意这里，不一定是0-length。也有可能是中间段
        int[] temp = Arrays.copyOfRange(array, start, end + 1);
        int leftStart = start, rightStart = mid + 1;
        for (int k = start; k <= end; k++) {
            if (leftStart > mid) {
                array[k] = temp[rightStart - start];
                rightStart++;
            } else if (rightStart > end) {
                array[k] = temp[leftStart - start];
                leftStart++;
            } else if (temp[leftStart - start] > temp[rightStart - start]) {
                array[k] = temp[rightStart - start];
                rightStart++;
            } else {
                array[k] = temp[leftStart - start];
                leftStart++;
            }
        }

        TestUtil.printArray("测试合并：", array);
    }

    public static void main(String[] args) {
//        testConcat();
        rightOne2Zero(7);
        sumOneCount(7);
//        revertBit(10);
//        testMaoPao();
//        selectionSort();
//        insertSort();
//        String[] arrays = new String[]{"a","b","c","d","e","f","g","h"};
//        revertStrings(0,2,arrays);
//        revertStrings(3,arrays.length-1,arrays);
//        revertStrings(0,arrays.length-1,arrays);
//        System.out.println(testSearch(17));
//        System.out.println(testSearchCircle(0,array.length-1,17));
        int[] array = new int[]{6, 4, 3, 7, 9, 10, 2, 14, 17};
//        testQuickSort(array,0,array.length-1);
        TestUtil.printArray("快速排序：", array);
//        mergeArray();
//        mergeArrayInsert();
//        testMergeArray();
//        System.out.println(weiSum());
//        System.out.println(fun("Smart"));
    }

}
