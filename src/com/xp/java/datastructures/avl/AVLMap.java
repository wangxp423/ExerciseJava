package com.xp.java.datastructures.avl;

import com.xp.java.datastructures.set_map.map.Map;

/**
 * @类描述：基于AVL平衡树的 映射集合map
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/8 0008 14:42
 * @修改人：
 * @修改时间：2018/8/8 0008 14:42
 * @修改备注：
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {
    private AVLTree<K, V> avlTree;

    public AVLMap() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(K key, V val) {
        avlTree.add(key, val);
    }

    @Override
    public V remove(K key) {
        return remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public void set(K key, V value) {
        avlTree.set(key, value);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
