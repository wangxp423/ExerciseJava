package com.xp.java.leetcode;

/**
 * @类描述：链表的中间节点
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/6 0006 11:46
 * @修改人：
 * @修改时间：2018/9/6 0006 11:46
 * @修改备注：
 */
public class Solution_0876 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //题目中给到最大100
    public ListNode middleNode(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode[] list = new ListNode[100];
        int index = 0;
        while (null != dummyHead.next) {
            list[index++] = dummyHead.next;
            dummyHead = dummyHead.next;
        }
        return list[index / 2];
    }

    public ListNode middleNode1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next) {
            slow = head.next;
            fast = head.next.next;
        }
        return slow;
    }
}
