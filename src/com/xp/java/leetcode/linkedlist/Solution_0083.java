package com.xp.java.leetcode.linkedlist;

/**
 * @类描述：leetcode83 删除链表重复元素
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/6 0006 14:31
 * @修改人：
 * @修改时间：2018/9/6 0006 14:31
 * @修改备注：
 */
public class Solution_0083 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (null != current && null != current.next) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution_0083 solution = new Solution_0083();
        System.out.println(printLinked(solution.getListNode()));
        System.out.println(printLinked(solution.deleteDuplicates(solution.getListNode())));
    }

    private ListNode getListNode() {
        ListNode dummyHead = new ListNode(-1);
        int[] nums = {3, 3, 2, 1, 1};
        for (int i = 0; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            temp.next = dummyHead.next;
            dummyHead.next = temp;
        }
        return dummyHead.next;
    }

    private static String printLinked(ListNode node) {
        StringBuilder res = new StringBuilder();
        for (ListNode cur = node; cur != null; cur = cur.next) {
            res.append(cur.val + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
