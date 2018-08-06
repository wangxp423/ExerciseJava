package com.xp.java.datastructures.union_find;

import java.util.Random;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/3 0003 14:22
 * @修改人：
 * @修改时间：2018/8/3 0003 14:22
 * @修改备注：
 */
public class TestUnionFind {
    private static double testUF(UF uf, int m) {

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        // UnionFind1 慢于 UnionFind2
//        int size = 100000;
//        int m = 10000;

        // UnionFind2 慢于 UnionFind1, 但UnionFind3最快
        int size = 10000000;
        int m = 10000000;

        //基于数组 如果合并 直接将id改为相同，但是需要遍历数组
//        UnionFind1 uf1 = new UnionFind1(size);
//        System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");

        //基于数组 如果合并 将合并去过的id指向合并数的id。
//        UnionFind2 uf2 = new UnionFind2(size);
//        System.out.println("UnionFind2 : " + testUF(uf2, m) + " s");

        //基于数组 如果合并 我们将比较根节点所在的树节点的size大小，小的往大的上面合并
        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3 : " + testUF(uf3, m) + " s");

        //基于数组 如果合并 我们将比较根节点所在的树的深度rank大小，小的往大的上面合并，以保证深度。因为树的查找最终是深度h决定的。
        UnionFind4 uf4 = new UnionFind4(size);
        System.out.println("UnionFind4 : " + testUF(uf4, m) + " s");

        //基于数组 如果合并 我们将比较根节点所在的树的深度rank大小，同时查找的时候我们通过压缩路径来查找
        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("UnionFind5 : " + testUF(uf5, m) + " s");

        //基于数组 如果合并 我们将比较根节点所在的树的深度rank大小，同时查找的时候我们通过压缩路径来查找
        UnionFind6 uf6 = new UnionFind6(size);
        System.out.println("UnionFind6 : " + testUF(uf6, m) + " s");
    }
}
