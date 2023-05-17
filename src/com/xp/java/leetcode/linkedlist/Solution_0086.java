package com.xp.java.leetcode.linkedlist;

import com.xp.java.leetcode.ListNode;
import com.xp.java.util.TestUtil;

/**
 * @类描述：leetcode86 给出一个链表和一个数字x，重新整理链表使得小于x元素在前大于x的元素在后
 * @创建人：Wangxiaopan
 * @创建时间：2023/5/6 0006 14:31
 * @修改人：
 * @修改时间：2023/5/6 0006 14:31
 * @修改备注：
 */
public class Solution_0086 {
    public static void main(String[] args) {
        ListNode node = getNode();
        TestUtil.printListNode(node);
//        TestUtil.printListNode(partition(node,2));
        TestUtil.printListNode(partition1(node, 3));
    }

    //分割链表 用两个指针作为之交换
    public static ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pcur = dummyHead.next;
        ListNode prev = pcur;
        while (null != prev.next) {
            if (pcur.val < x) {
                if (prev.next.val < x) {
                    pcur = pcur.next;
                    prev = prev.next;
                } else {
                    prev = prev.next;
                }
                if (prev.next.val < x) {
                    ListNode temp = new ListNode(prev.next.val);
                    prev.next = prev.next.next;
                    ListNode next = pcur.next;
                    pcur.next = temp;
                    temp.next = next;
                    pcur = pcur.next;
                }
            } else {
                if (prev.next.val < x) {

                } else {
                    prev = prev.next;
                }
                if (prev.next.val < x) {
                    ListNode temp = new ListNode(prev.next.val);
                    prev.next = prev.next.next;
                    temp.next = pcur;
                    dummyHead.next = temp;
                    pcur = pcur.next;
                }
            }
        }
        return dummyHead.next;
    }

    //维护两个链表，一个小于的链表，一个大于的链表，然后在合并即可
    public static ListNode partition1(ListNode head, int x) {
        ListNode dummySmall = new ListNode(-1);
        ListNode dummyLarge = new ListNode(-1);
        ListNode curSmall = dummySmall;
        ListNode curLarge = dummyLarge;
        while (null != head) {
            if (head.val < x) {
                curSmall.next = new ListNode(head.val);
                curSmall = curSmall.next;
            } else {
                curLarge.next = new ListNode(head.val);
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curSmall.next = dummyLarge.next;
        return dummySmall.next;
    }

    public static ListNode getNode() {
        ListNode head = new ListNode(-1);
        int[] nums = {2, 5, 2, 3, 4, 1};
//        int[] nums = {2,5,2,3,1,1};
//        int[] nums = {1,2};
        return head.getListNode(nums);
    }

}
