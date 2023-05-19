package com.xp.java.leetcode.linkedlist;

import com.xp.java.leetcode.ListNode;
import com.xp.java.util.TestUtil;

/**
 * @类描述：leetcode328 给出一个链表，重新整理链表，使得索引为奇数的节点在索引为偶数的节点前面，同时保持有序性
 * @创建人：Wangxiaopan
 * @创建时间：2023/5/6 0006 14:31
 * @修改人：
 * @修改时间：2023/5/6 0006 14:31
 * @修改备注：
 */
public class Solution_0328 {

    /**
     * 给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     * <p>
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
     * <p>
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     * <p>
     * 你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
     **/

    public static void main(String[] args) {
        ListNode head = getNode();
        TestUtil.printListNode(head);
        TestUtil.printListNode(oddEvenList1(head));
        TestUtil.printListNode(oddEvenList(head));
    }

    //题解 奇偶链表 首位是基数第二位是偶数而且是有序的。
    public static ListNode oddEvenList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);
        ListNode curOdd = dummyOdd;
        ListNode curEven = dummyEven;
        while (null != head) {
            if (head.val % 2 == 0) {
                //Even 偶数
                if (curEven.next == null) {
                    curEven.next = new ListNode(head.val);
                } else {
                    if (head.val < curEven.next.val) {
                        ListNode temp = new ListNode(head.val);
                        temp.next = dummyEven.next;
                        dummyEven.next = temp;
                    } else {
                        ListNode curNode = dummyEven;
                        while (null != curNode.next && head.val >= curNode.next.val) {
                            curNode = curNode.next;
                        }
                        if (null == curNode.next) {
                            curNode.next = new ListNode(head.val);
                        } else {
                            ListNode temp = new ListNode(head.val);
                            temp.next = curNode.next;
                            curNode.next = temp;
                        }
                    }
                }
            } else {
                //odd 奇数
                if (curOdd.next == null) {
                    curOdd.next = new ListNode(head.val);
                } else {
                    if (head.val < curOdd.next.val) {
                        ListNode temp = new ListNode(head.val);
                        temp.next = dummyOdd.next;
                        dummyOdd.next = temp;
                    } else {
                        ListNode curNode = dummyOdd;
                        while (null != curNode.next && head.val >= curNode.next.val) {
                            curNode = curNode.next;
                        }
                        if (null == curNode.next) {
                            curNode.next = new ListNode(head.val);
                        } else {
                            ListNode temp = new ListNode(head.val);
                            temp.next = curNode.next;
                            curNode.next = temp;
                        }
                    }
                }
            }
            head = head.next;
        }
        while (null != curOdd.next) {
            curOdd = curOdd.next;
        }
        curOdd.next = dummyEven.next;
        return dummyOdd.next;
    }

    public static ListNode getNode() {
        ListNode head = new ListNode(-1);
        int[] nums = {1, 2, 3, 4, 5, 6};
//        int[] nums = {6,5,4,3,2,1};
//        int[] nums = {2,1,6,5,4,3};
        return head.getListNode(nums);
    }
}
