package com.xp.java.leetcode.linkedlist;

import com.xp.java.leetcode.ListNode;
import com.xp.java.util.TestUtil;

/**
 * @类描述：Leetcode19
 * @创建人：Wangxiaopan
 * @创建时间：2018/11/7 0007 11:21
 * @修改人：
 * @修改时间：2018/11/7 0007 11:21
 * @修改备注：
 */
public class Solution_0019 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head; //倒数第几个，那么fast就先走几步，当fast走到最后的时候，slow就是当前要删除的节点。然后删除就行了。
        ListNode slow = head;
        while (n > 0) {
            n--;
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;

    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ListNode node = new ListNode(-1);
        node.getListNode(array);
        System.out.println(node);
        TestUtil.printListNode(removeNthFromEnd(node.dummyHead.next, 2));
    }
}
