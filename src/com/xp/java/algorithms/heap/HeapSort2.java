package com.xp.java.algorithms.heap;

/**
 * @类描述：最大堆排序 基于最大堆
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/20 0020 11:44
 * @修改人：
 * @修改时间：2018/8/20 0020 11:44
 * @修改备注：
 */
public class HeapSort2 {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sort(array);
    }

    //对一个数组 进行自动调整，使其成为一个最大堆
    public static void sort(Comparable[] array) {
        int n = array.length;
        //主要此时我们的索引从0开始，拿到树的倒数第二层的最右边的节点的位置
        //然后依次往上遍历节点，对这些节点进行上移操作
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, n, i);
        }
        //生成最大堆以后，我们知道 最大堆的第一个元素肯定是最大的
        //我们将最大的元素和最后一个元素交换位置，然后再将第一个元素进行下移操作，之后这个数组就是一个有序的了。
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            //注意这里这里 第二个参数要为i。因为交换以后 最大的在最后了。前面的在进行的时候要不能包含最后一个。
            //此时的i 即为当前树的最有一个节点，也可以理解为长度。
            shiftDown(array, i, 0);
        }
//        SortTestHelper.printArray(array);
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    //索引从0开始 根据堆的树性质，完全二叉树
    //所以如果父节点为n 那么 left = 2*n+1 right = 2*n+2
    private static void shiftDown(Comparable[] array, int n, int k) {
        Comparable note = array[k];
        while (2 * k + 1 < n) {//判断节点左节点是否越界
            int left = 2 * k + 1;
            if (left + 1 < n && array[left + 1].compareTo(array[left]) > 0) {
                left = left + 1; //比较左右两个节点的大小，记录大的节点的索引
            }
            //如果节点 比左右子节点都大 那么不做操作
            if (note.compareTo(array[left]) >= 0) break;

            //不然的话 交换两个元素的位置
            array[k] = array[left];
            k = left;
        }
        //交换
        array[k] = note;
    }
}
