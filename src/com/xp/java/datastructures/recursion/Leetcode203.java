package com.xp.java.datastructures.recursion;

/**
 * @类描述：用递归去删除指定节点
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/24 0024 16:52
 * @修改人：
 * @修改时间：2018/7/24 0024 16:52
 * @修改备注：
 */
public class Leetcode203 {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead; //虚拟头节点可以避免 .next.next的空指针
        while (null != pre.next) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode removeElements1(ListNode head, int val) {
        if (null == head) return head;
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}
