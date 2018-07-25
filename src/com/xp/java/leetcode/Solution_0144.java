package com.xp.java.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @类描述：leetcode 144题 前序遍历，但是不能用递归
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/25 0025 10:26
 * @修改人：
 * @修改时间：2018/7/25 0025 10:26
 * @修改备注：
 */
public class Solution_0144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (null == root) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            //既然是前序遍历，所以入栈的时候要先入右节点
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}
