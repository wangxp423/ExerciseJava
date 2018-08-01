package com.xp.java.datastructures.segment_tree;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/1 0001 11:08
 * @修改人：
 * @修改时间：2018/8/1 0001 11:08
 * @修改备注：
 */
public class TestSegmentTree {
    public static void main(String[] args) {
//        testSegmentTree();
//        testQuery();
        testSet();
    }

    private static void testSegmentTree() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree);
    }

    private static void testQuery() {
        //这个查区间的，就是leetcode 303题，可以使用线段树的方式来实现
        //在leetcode -> Solution_303有另一种解法
        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        System.out.println(segTree);

        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));
    }

    private static void testSet() {
        //更新数组元素的，就是leetcode 307题，可以使用线段树的方式来实现
        //在leetcode -> Solution_307有另一种解法
        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        System.out.println(segTree);
        segTree.set(0, -1);
        System.out.println(segTree);
    }
}
