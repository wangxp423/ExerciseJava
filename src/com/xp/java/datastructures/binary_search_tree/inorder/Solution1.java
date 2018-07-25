package com.xp.java.datastructures.binary_search_tree.inorder;/// Source : https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
/// Author : liuyubobobo
/// Time   : 2018-05-30

import com.xp.java.datastructures.binary_search_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Classic Non-Recursive algorithm for inorder traversal
// Time Complexity: O(n), n is the node number in the tree
// Space Complexity: O(h), h is the height of the tree
public class Solution1 {

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
