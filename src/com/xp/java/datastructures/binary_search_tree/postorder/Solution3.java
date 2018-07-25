package com.xp.java.datastructures.binary_search_tree.postorder;/// Source : https://leetcode.com/problems/binary-tree-postorder-traversal/description/
/// Author : liuyubobobo
/// Time   : 2018-07-03

import com.xp.java.datastructures.binary_search_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// Non-Recursive
// Using two stacks, Reverse Preorder Traversal!
//
// Time Complexity: O(n)
// Space Complexity: O(n)
public class Solution3 {

    public List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> output = new LinkedList<>();

        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                output.push(p);
                p = p.right;
            } else {
                p = stack.pop();
                p = p.left;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!output.isEmpty())
            res.add(output.pop().val);
        return res;
    }
}
