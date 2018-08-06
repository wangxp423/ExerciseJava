package com.xp.java.datastructures.union_find;

/**
 * @类描述：并查集 压缩路径
 * 基于数组实现。 合并的时候(p,q)我们将q的id变为p的id，以此来表示q是p的子节点，
 * 然后其他在合并的时候我们找到要合并的根节点，然后合并根节点即可
 * 这样合并的结果是，有可能造成一条单链，然后进而影响搜索效率
 * 这里呢，我们并不维护rank的语意，也就是rank的值在路径压缩的过程中，可能不是在树的层数值
 * 这也是我们这里rank不叫height或者depth的原因，他只是作为一个比较的标准。
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/6 0006 9:50
 * @修改人：
 * @修改时间：2018/8/6 0006 9:50
 * @修改备注：
 */
public class UnionFind5 implements UF {
    private int[] parent;//parent[i]表示第i个元素所指向的父节点
    private int[] rank;//rank[i]表示以i为根的集合所表示的树的层数

    public UnionFind5(int size) {
        rank = new int[size];
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        //根据两个元素所在树的rank高度不同判断合并方向
        //将rank高度低的合并到rank高度高的集合上，这样有助于保持总体树的高度不增加
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] = rank[qRoot] + 1; //如果两个相等，并到另一个以后，要+1
        }

    }

    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;

    }

}
