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
            dummyHead.next = this;
        }
        if (node == null) return dummyHead.next;
        node.next = dummyHead.next;
        dummyHead.next = node;
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

    public static ListNode normalListNode() {
        ListNode node = new ListNode(1)
                .addNode(new ListNode(2))
                .addNode(new ListNode(3));
        return node;
    }

    public static ListNode array2ListNode(int[] nums) {
        ListNode node = new ListNode(1);
        return node.getListNode(nums);
    }
}
