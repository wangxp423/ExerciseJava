package com.xp.java.leetcode;

import com.xp.java.datastructures.binary_search_tree.BSTree;

/**
 * @类描述：二叉树的最小深度 这个可以参考 0104 最小深度的题
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/5 0005 14:31
 * @修改人：
 * @修改时间：2018/9/5 0005 14:31
 * @修改备注：
 */
public class Solution_0111 {
    public static void main(String[] args) {
        System.out.println(setTree());
        System.out.println("minDepth = " + minDepth(setTree().getRoot()));
    }


    //仔细分析最小深度的时候，细节在于 当左边为null，最小深度要按照右边来算。比如[1,2]的深入是2  而不是1
    public static int minDepth(BSTree.Node root) {
        if (null == root) return 0;
        if (null == root.left) return 1 + minDepth(root.right);
        if (null == root.right) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
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
        int[] nums = {5, 3, 6, 4, 2, 1};
        for (int num : nums)
            bst.add(num);
        return bst;
    }
}
