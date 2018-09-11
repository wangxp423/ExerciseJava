package com.xp.java.leetcode;

/**
 * @类描述：LeetCode 上链表和二叉树用到的节点
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/11 0011 15:09
 * @修改人：
 * @修改时间：2018/9/11 0011 15:09
 * @修改备注：
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode dummyHead;

    public ListNode(int x) {
        val = x;
    }


    public ListNode addNode(ListNode node) {
        if (dummyHead == null) {
            dummyHead = new ListNode(-1);
        }
        if (node == null) return dummyHead.next;
        ListNode temp = dummyHead.next;
        dummyHead.next = node;
        node.next = temp;
        return dummyHead.next;
    }

    public ListNode getListNode(int[] nums) {
        if (dummyHead == null) {
            dummyHead = new ListNode(-1);
        }
        for (int i = 0; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            temp.next = dummyHead.next;
            dummyHead.next = temp;
        }
        return dummyHead.next;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (ListNode cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur.val + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
