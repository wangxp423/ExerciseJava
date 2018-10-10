package com.xp.java.leetcode;

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
    //我疑惑的地方在于 不是要删除节点吗 为什么没有指定节点呢？ 看了网上的描述说node节点就是要删除的节点。
    public static void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //这是递归写法
    public static ListNode deleteNode(ListNode node, int val) {
        if (node.val == val) {
            return node.next;
        } else {
            return node;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-1);
        int[] list = new int[]{9, 1, 5, 4};
        ListNode node = listNode.getListNode(list);
        TestUtil.printListNode(node);

        deleteNode(node);
        TestUtil.printListNode(node);
    }
}
