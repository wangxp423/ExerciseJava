package com.xp.java.datastructures.heap;

import com.xp.java.util.SortTestHelper;
import com.xp.java.util.TestUtil;

import java.util.Arrays;

/**
 * @类描述：最大索引堆 维护一个数组，用来记录data数组索引
 * 维护另外一个数组，用来记录data索引 在indexs中的位置
 * 其中维护的数组的索引都是从1 开始的
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/20 0020 16:36
 * @修改人：
 * @修改时间：2018/8/20 0020 16:36
 * @修改备注：
 */
public class IndexMaxHeap1<T extends Comparable> {
    protected T[] data;     //最大索引堆的数据
    protected int[] indexs; //最大索引堆的索引，indexs[x] = i; 表示索引i 在x的位置 表示data[i] 在 index堆中的位置是x
    protected int[] reverse; //最大索引堆的反向索引，reverse[i] = x,表示索引data[i] 在index中的位置是x
    //这里的反向索引，主要是为了优化change操作，因为在change中当要change i 的时候，我们首先要找到data[i]
    //然后去遍历indexs，去找i 在indexs中的位置，这个遍历的时间复杂度是O(n)太麻烦
    //这个时候我们用reverse去存储 i 在 indexs中的位置，这个时候的时间复杂度就变成了O(1)了。
    protected int size;
    protected int capacity;

    public IndexMaxHeap1(int capacity) {
        data = (T[]) new Comparable[capacity + 1];
        indexs = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
        }
        size = 0;
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //i 的位置是最后一个位置，插入都是从最后插入 然后上浮。
    //向最大索引堆中插入新元素 索引为i 元素为 e
    //传入的i 对用户而言是从0索引的,而我们内部维护的时候 索引是从1 开始的。
    public void insert(int i, T e) {
        //首先进行 索引和容量的判断
        assert size + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;
        //再插入一个新元素前，要保证索引i所在的位置是没有元素的。
        assert !contain(i);
        i += 1;
        data[i] = e;
        indexs[size + 1] = i;
        reverse[i] = size + 1;
        size++;
        shiftUp(size);
    }

    //从最大索引堆中取出堆顶元素
    public T extractMax() {
        assert size > 0;
        T ret = data[indexs[1]];
        swapIndexs(1, size);
        reverse[indexs[size]] = 0;
        size--;
        shiftDown(1);
        return ret;
    }

    //从最大索引堆中取出项顶元素的索引
    public int extractMaxIndex() {
        assert size > 0;
        int ret = indexs[1] - 1;
        swapIndexs(1, size);
        reverse[indexs[size]] = 0;
        size--;
        shiftDown(1);
        return ret;
    }

    //获取最大堆中的堆顶元素
    public T getMax() {
        assert size > 0;
        return data[indexs[1]];
    }

    //获取最大堆中的堆顶元素
    public int getMaxIndex() {
        assert size > 0;
        return indexs[1] - 1;
    }

    //获取最大索引堆中 索引为index的元素
    public T getItem(int index) {
        assert index + 1 >= 1 && index + 1 <= capacity;
        return data[index + 1];
    }

    public boolean contain(int i) {
        assert i + 1 >= 1 && i + 1 <= capacity;
        return reverse[i + 1] != 0;
    }

    //将最大索引堆中索引为i的元素修改为newItem
    public void change(int i, T newItem) {
        assert !contain(i);
        i += 1;
        data[i] = newItem;
//        //找到indexs[j] = i; j表示data[i] 在堆中的位置。
//        for (int j = 1; j <= size; j++) {
//            if (indexs[j] == i) {
//                shiftUp(j);
//                shiftDown(j);
//                return;
//            }
//        }
        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }

    private void swapIndexs(int i, int j) {
        int temp = indexs[i];
        indexs[i] = indexs[j];
        indexs[j] = temp;

        reverse[indexs[i]] = i;
        reverse[indexs[j]] = j;
    }

    private void shiftUp(int k) {
        while (k > 1 && data[indexs[k / 2]].compareTo(data[indexs[k]]) < 0) {
            swapIndexs(k, k / 2);
            k = k / 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k < size) {
            int left = 2 * k;
            if (left + 1 < size && data[indexs[left + 1]].compareTo(data[indexs[left]]) > 0) {
                left++;
            }
            if (data[indexs[k]].compareTo(data[indexs[left]]) >= 0) {
                break;
            }
            swapIndexs(k, left);
            k = left;
        }
    }

    // 测试索引堆中的索引数组indexs和反向reverse
    // 注意:这个测试在向堆中插入元素以后, 不进行extract操作有效
    public boolean testIndexes() {

        int[] copyIndexes = new int[size + 1];
        int[] copyReverseIndexes = new int[size + 1];

        for (int i = 0; i <= size; i++) {
            copyIndexes[i] = indexs[i];
            copyReverseIndexes[i] = reverse[i];
        }

        copyIndexes[0] = 0;
        copyReverseIndexes[0] = 0;
        Arrays.sort(copyIndexes);
        Arrays.sort(copyReverseIndexes);

        // 在对索引堆中的索引和反向索引进行排序后,
        // 两个数组都应该正好是1...count这count个索引
        boolean res = true;
        for (int i = 1; i <= size; i++)
            if (copyIndexes[i - 1] + 1 != copyIndexes[i] ||
                    copyReverseIndexes[i - 1] + 1 != copyReverseIndexes[i]) {
                res = false;
                break;
            }

        if (!res) {
            System.out.println("Error!");
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        int N = 10;
        IndexMaxHeap1<Integer> indexMaxHeap = new IndexMaxHeap1<Integer>(N);
        for (int i = 0; i < N; i++)
            indexMaxHeap.insert(i, (int) (Math.random() * N));
        assert indexMaxHeap.testIndexes();

        SortTestHelper.printArray(indexMaxHeap.data);
        TestUtil.printArray("最大索引堆", indexMaxHeap.indexs);
    }
}