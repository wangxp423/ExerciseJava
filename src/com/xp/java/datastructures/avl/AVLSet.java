package com.xp.java.datastructures.avl;

import com.xp.java.datastructures.set_map.set.Set;

/**
 * @类描述：基于AVL平衡树的 set集合
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/8 0008 13:02
 * @修改人：
 * @修改时间：2018/8/8 0008 13:02
 * @修改备注：
 */
public class AVLSet<T extends Comparable<T>> implements Set<T> {
    private AVLTree<T, Object> avl;

    public AVLSet() {
        avl = new AVLTree<>();
    }

    @Override
    public void add(T e) {
        avl.add(e, null);
    }

    @Override
    public boolean contains(T e) {
        return avl.contains(e);
    }

    @Override
    public void remove(T e) {
        avl.remove(e);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
