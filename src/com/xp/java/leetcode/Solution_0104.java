package com.xp.java.leetcode;

import com.xp.java.datastructures.binary_search_tree.BSTree;

/**
 * @类描述：二叉树的最大深度
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/5 0005 14:31
 * @修改人：
 * @修改时间：2018/9/5 0005 14:31
 * @修改备注：
 */
public class Solution_0104 {
    public static void main(String[] args) {
        System.out.println(setTree());
        System.out.println("maxDepth = " + maxDepth(setTree().getRoot()));
        System.out.println("maxDepth1 = " + maxDepth1(setTree().getRoot()));
    }

    //又试了一下这种方法，竟然在LeetCode上通过了。
    public static int maxDepth1(BSTree.Node root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }

    //这是我自己想的一种方法，用小数据试了一下可以，但是提交LeetCode反馈超出时间限制。
    //本来想删除，留下来也算是一种思路吧。
    public static int maxDepth(BSTree.Node root) {
        if (null == root) return 0;
        if (null == root.left) {
            return maxDepth(root.right) + 1;
        }
        if (null == root.right) {
            return maxDepth(root.left) + 1;
        }
        if (maxDepth(root.left) > maxDepth(root.right)) {
            return maxDepth(root.left) + 1;
        } else {
            return maxDepth(root.right) + 1;
        }
    }

    public static BSTree<Integer> setTree() {
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        BSTree<Integer> bst = new BSTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2, 1};
        for (int num : nums)
            bst.add(num);
        return bst;
    }
}
