package com.xp.java.datastructures.union_find;

/**
 * @类描述：并查集 基于数组实现。 用数组中值相同 来表示在一个集中。
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/3 0003 10:49
 * @修改人：
 * @修改时间：2018/8/3 0003 10:49
 * @修改备注：
 */
public class UnionFind1 implements UF {
    private int[] id;

    public UnionFind1(int size) {//输入多少个数(数量)
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i; //默认处理，当前这个数所在的集就是自己本身，这样就可以确保所有数都不在同一个集中。
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        for (int i = 0; i < id.length; i++) { //合并要将两个数本身所在的集(ID一样的)中的所有数都置为一样的。
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }
}
