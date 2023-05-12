package com.xp.java.leetcode.linkedlist;

import com.xp.java.leetcode.ListNode;
import com.xp.java.util.TestUtil;

/**
 * @类描述：Leetcode237 删除链表中节点
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/10 0010 10:23
 * @修改人：
 * @修改时间：2018/10/10 0010 10:23
 * @修改备注：
 */
public class Solution_0237 {

    //这个题我看的有点懵逼，本来以为是用递归删除，后台提交失败，在网上搜都是这个写法。
    //题目是你只能访问要删除的节点，正常删除我们只需要让上一个节点指向要删除的下一个节点即可
    //但是这里我们访问不到上一个节点，所以我们将下一个节点赋值给当前节点，然后在删除下一个节点
    public static void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void deleteNode1(ListNode node) {
        ListNode next = node.next;
        // 交换node和next的值，删除node实则删除next即可
        int a = node.val;
        node.val = next.val;
        next.val = a;
        node.next = next.next;
        next = null;
    }

    //这是递归写法
    public static ListNode deleteNode(ListNode node, int val) {
        if (node == null) return null;
        ListNode result = deleteNode(node.next, val);
        if (node.val == val) {
            return result;
        } else {
            node.next = result;
            return node;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-1);
        int[] list = new int[]{9, 1, 5, 4};
        ListNode node = listNode.getListNode(list);
        TestUtil.printListNode(node);

        deleteNode1(node);
        TestUtil.printListNode(node);

//        TestUtil.printListNode(deleteNode(node,1));
    }
}
