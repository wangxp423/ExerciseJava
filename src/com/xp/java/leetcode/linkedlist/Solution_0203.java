package com.xp.java.leetcode.linkedlist;

import com.xp.java.leetcode.ListNode;
import com.xp.java.util.TestUtil;

/**
 * @类描述：leetcode第203 删除链表中的节点
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/20 0020 16:15
 * @修改人：
 * @修改时间：2018/7/20 0020 16:15
 * @修改备注：
 */
public class Solution_0203 {
    public static ListNode removeElements(ListNode head, int val) {
        if (null == head) return head;
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }

    public static ListNode removeNode(ListNode node, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = node;
        ListNode preNode = dummyHead;
        while (null != preNode.next) {
            if (preNode.next.val == val) {
                preNode.next = preNode.next.next;
            } else {
                preNode = preNode.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode removeNodeRecurion(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode result = removeNodeRecurion(head.next, val);
        if (head.val == val) {
            return result;
        } else {
            head.next = result;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode node = ListNode.array2ListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
        TestUtil.printListNode(node);
//        TestUtil.printListNode(removeNode(node,6));
        TestUtil.printListNode(removeNodeRecurion(node, 6));
        TestUtil.printListNode(removeElements(node, 6));
    }
}
