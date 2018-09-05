package com.xp.java.datastructures.binary_search_tree;

import java.util.Stack;

/**
 * @类描述：用自己写的BSTree(二分搜索树)测试中序遍历 因为二分搜索树的特性 中序遍历是有序的。
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/10 0010 15:09
 * @修改人：
 * @修改时间：2018/8/10 0010 15:09
 * @修改备注：
 */
public class BSTreeInorder {
    public static void main(String[] args) {
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        BSTree<Integer> bst = new BSTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        inOrder1(bst.getRoot());

    }


    //中序遍历
    private static void inOrder1(BSTree.Node root) {
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        Stack<BSTree.Node> stack = new Stack<>();
        BSTree.Node cur = root;
        while (null != cur || !stack.isEmpty()) {
            while (null != cur) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.e);
            cur = cur.right;
        }
    }
}
