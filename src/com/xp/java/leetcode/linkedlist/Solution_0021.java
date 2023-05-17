package com.xp.java.leetcode.linkedlist;

import com.xp.java.leetcode.ListNode;
import com.xp.java.util.TestUtil;

/**
 * @类描述：leetcode21 合并两个有序链表
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/11 0011 15:01
 * @修改人：
 * @修改时间：2018/9/11 0011 15:01
 * @修改备注：
 */
public class Solution_0021 {

    public static void main(String[] args) {
        ListNode node1 = getListNode1();
        ListNode node2 = getListNode2();
        TestUtil.printListNode(node1);
        TestUtil.printListNode(node2);
//        TestUtil.printListNode(mergeTwoLists1(node1, node2));
        TestUtil.printListNode(mergeTwoLists2(node1, node2));
//        TestUtil.printListNode(mergeTwoLists(node1, node2));
    }

    //这种方法是我自己想的。提交LeetCode也能通过。就是不太好
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        while (l1 != null || l2 != null) {
            if (null == l1) {
                addNode(l2);
                l2 = null;
            } else if (null == l2) {
                addNode(l1);
                l1 = null;
            } else if (l1.val >= l2.val) {
                addNode(new ListNode(l2.val));
                l2 = removeHead(l2);
            } else if (l1.val < l2.val) {
                addNode(new ListNode(l1.val));
                l1 = removeHead(l1);
            }
        }
//        TestUtil.printListNode(dummyHead.next);
        return null == dummyHead ? null : dummyHead.next;
    }

    public static ListNode dummyHead;

    public static void addNode(ListNode node) {
        if (null == dummyHead) {
            dummyHead = new ListNode(-1);
        }
        ListNode temp = dummyHead;
        while (null != temp.next) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public static ListNode removeHead(ListNode node) {
        if (null == node) return null;
        return node.next;
    }

    public static ListNode getListNode1() {
        ListNode head = new ListNode(-1);
        int[] nums = {5, 3, 1};
        return head.getListNode(nums);
    }

    public static ListNode getListNode2() {
        ListNode head = new ListNode(-1);
        int[] nums = {6, 4, 2};
        return head.getListNode(nums);
    }

    //方法1 递归实现
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists1(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists1(l1, l2.next);
        }
        return head;
    }

    //方法2
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = null;//当前操作的head的位置
        ListNode head = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (node == null) {
                    node = l1;
                    head = node;
                } else {
                    node.next = l1;
                    node = node.next;
                }
                l1 = l1.next;
            } else {
                if (node == null) {
                    node = l2;
                    head = node;
                } else {
                    node.next = l2;
                    node = node.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            node.next = l1;
        } else if (l2 != null) {
            node.next = l2;
        }
        return head;
    }
}
