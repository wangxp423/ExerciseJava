package com.xp.java.leetcode;

import com.xp.java.datastructures.recursion.ListNode;

/**
 * @类描述：leetcode第203题，删除链表中的节点
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/20 0020 16:15
 * @修改人：
 * @修改时间：2018/7/20 0020 16:15
 * @修改备注：
 */
public class Solution_0203 {
    public ListNode removeElements(ListNode head, int val) {
        if (null == head) return head;
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}
