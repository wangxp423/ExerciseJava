package com.xp.java.datastructures.union_find;

/**
 * @类描述：并查集 基于数组实现。 合并的时候(p,q)我们将q的id变为p的id，以此来表示q是p的子节点，
 * 然后其他在合并的时候我们找到要合并的根节点，然后合并根节点即可
 * 这样合并的结果是，有可能造成一条单链，然后进而影响搜索效率
 * 但是，这里呢，我们在维护一个size长度。在合并的时候，短的要合并到长的上面，直接到根节点位置。
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/3 0003 10:49
 * @修改人：
 * @修改时间：2018/8/3 0003 10:49
 * @修改备注：
 */
public class UnionFind3 implements UF {
    private int[] parent;
    private int[] sz;

    // 我们的第二版Union-Find, 使用一个数组构建一棵指向父节点的树
    // parent[i]表示第一个元素所指向的父节点
    public UnionFind3(int size) {//输入多少个数(数量)
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1; //默认长度都是1
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
        //根绝两个元素所在树的元素个数的不同判断合并方向
        //将元素少的集合合并到元素多的集合上
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] = sz[qRoot] + sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] = sz[qRoot] + sz[pRoot];
        }
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        while (p != parent[p]) { //说明该节点有父节点
            p = parent[p]; //此时的p 为父节点的id，然后一路向上找，当p = parent[p]的时候 他就是父节点了。
        }
        return p;
    }
}
