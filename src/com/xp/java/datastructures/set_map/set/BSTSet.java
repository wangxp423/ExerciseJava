package com.xp.java.datastructures.set_map.set;

import com.xp.java.datastructures.binary_search_tree.BSTree;

/**
 * @类描述：基于二分搜索树的set集合，因为之前的二分搜索树没有对=做处理，所以默认是不支持重复的。所以满足set不重复要求
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/26 0026 9:53
 * @修改人：
 * @修改时间：2018/7/26 0026 9:53
 * @修改备注：
 */
public class BSTSet<T extends Comparable<T>> implements Set<T> {
    private BSTree<T> bsTree;

    public BSTSet() {
        bsTree = new BSTree<>();
    }

    @Override
    public void add(T e) {
        bsTree.add(e);
    }

    @Override
    public boolean contains(T e) {
        return bsTree.contains(e);
    }

    @Override
    public void remove(T e) {
        bsTree.remove(e);
    }

    @Override
    public int getSize() {
        return bsTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bsTree.isEmpty();
    }
}
