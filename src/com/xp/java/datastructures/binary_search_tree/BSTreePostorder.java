package com.xp.java.datastructures.binary_search_tree;

import java.util.Stack;

/**
 * @类描述：用自己写的BSTree(二分搜索树)测试后序遍历 因为二分搜索树的特性 中序遍历是有序的。
 * @创建人：Wangxiaopan
 * @创建时间：2018/8/10 0010 15:09
 * @修改人：
 * @修改时间：2018/8/10 0010 15:09
 * @修改备注：
 */
public class BSTreePostorder {
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

        postOrder1(bst.getRoot());

    }


    //中序遍历
    private static void postOrder1(BSTree.Node root) {
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        //这个写法会发现跟前序遍历(用栈)逻辑有点像，只不过前序是先右在左，而后续是先左再右，然后在放到另外一个栈中在出栈。
        Stack<BSTree.Node> stack = new Stack<>();
        Stack<Integer> output = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BSTree.Node note = stack.pop();
            output.push((Integer) note.e);
            if (null != note.left) {
                stack.push(note.left);
            }
            if (null != note.right) {
                stack.push(note.right);
            }
        }
        while (!output.isEmpty()) {
            System.out.println(output.pop());
        }
    }
}
