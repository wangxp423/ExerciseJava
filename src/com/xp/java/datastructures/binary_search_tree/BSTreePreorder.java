package com.xp.java.datastructures.binary_search_tree;

import java.util.Stack;

/**
 * @类描述：用自己写的BSTree(二分搜索树)测试前序遍历
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/10 0010 15:09
 * @修改人：
 * @修改时间：2018/8/10 0010 15:09
 * @修改备注：
 */
public class BSTreePreorder {
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

//        preOrder1(bst.getRoot());
//        preOrder2(bst.getRoot());
        preOrder3(bst.getRoot());
    }

    private static void preOrder3(BSTree.Node root) {
        if (null == root) return;
        System.out.println(root.e);
        preOrder3(root.left);
        preOrder3(root.right);
    }

    //前序遍历
    private static void preOrder1(BSTree.Node root) {
        Stack<BSTree.Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BSTree.Node node = stack.pop();
            System.out.println(node.e);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //前序遍历
    private static void preOrder2(BSTree.Node root) {
        Stack<BSTree.Node> stack = new Stack<>();
        BSTree.Node cur = root;
        while (null != cur || !stack.isEmpty()) {
            while (null != cur) {
                System.out.println(cur.e);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }
}
