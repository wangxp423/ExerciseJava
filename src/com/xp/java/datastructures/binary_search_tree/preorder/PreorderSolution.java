package com.xp.java.datastructures.binary_search_tree.preorder;/// Source : https://leetcode.com/problems/binary-tree-preorder-traversal/description/
/// Author : liuyubobobo
/// Time   : 2018-05-29

import com.xp.java.datastructures.binary_search_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

// PreOrder Morris Traversal
// Time Complexity: O(n), n is the node number in the tree
// Space Complexity: O(1)
public class PreorderSolution {

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;

                if (prev.right == null) {
                    res.add(cur.val);
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }

        return res;
    }
}
