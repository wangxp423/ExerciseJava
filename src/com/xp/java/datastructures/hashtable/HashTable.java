package com.xp.java.datastructures.hashtable;

import java.util.TreeMap;

/**
 * @类描述：哈希表 哈希表之所以效率高是因为哈希表是以数组为基础的，我们知道数组可以说是效率最高的数据结构。
 * 哈希表是通过一种哈希算法(hashcode),当然我们可以自定义，系统也有默认的各种hash算法。然后将对应的值放入数组中。索引就对应的是hashcode算出来的值
 * 我们知道一个类。都说有hashcode和equqls两个方法的。这两个方法就是重写hash算法和比较规则的。
 * 一般来说最常规的hash算法就是将我们要比较的值取模一个素数。这样可以保障最后的结果不重复的可能性更大
 * <p>
 * 为什么我们在用hash表的时候。里面要用一个TreeMap树形结构呢。是因为如果在hashCode一样的情况下。我们不会导致数据存储失败。而系统自带的也有有处理hash冲突的机制。
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/13 0013 10:07
 * @修改人：
 * @修改时间：2018/8/13 0013 10:07
 * @修改备注：
 */
public class HashTable<K, V> {
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K, V>[] hashtable;
    private int size;
    private int M;

    public HashTable(int capacity) {
        hashtable = new TreeMap[capacity];
        for (int i = 0; i < capacity; i++) {
            hashtable[i] = new TreeMap<>();
        }
        size = 0;
        M = capacity;
    }

    public HashTable() {
        this(97);
    }

    public int getSize() {
        return size;
    }

    //自定义的一个hash算法，
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(K key, V value) {
//        testHashCode(key);
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;

            if (size >= upperTol * M) {
                resize(2 * M);
            }
        }
    }

    //这个测试我发现一个问题，当capacity很小的时候，打印出来的hashCode是有重复的。
    //但是在map.containsKey()却判断永远是false ，但是实际put的时候  却会把hashCode一样的 给覆盖了。
    //我猜测，这里的hashCode表面上看是一样的，但是因为用到了系统的hashCode算法。所以系统会认为是不一样的。所以contians一直是false
    private void testHashCode(K key) {
        int hashCode = hash(key);
        System.out.println("hashCode = " + hashCode);
        TreeMap<Integer, K> map = new TreeMap<>();
        if (map.containsKey(hashCode)) {
            System.out.println("Key = " + key + " hashCode = " + hashCode);
        } else {
            map.put(hashCode, key);
        }
    }

    public V remove(K key) {
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;

            if (size < lowerTol * M && M / 2 >= initCapacity)
                resize(M / 2);
        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");

        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

    //自动扩容缩容
    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++)
            newHashTable[i] = new TreeMap<>();

        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet())
                newHashTable[hash(key)].put(key, map.get(key));
        }

        this.hashtable = newHashTable;
    }
}
