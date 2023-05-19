package com.xp.java.leetcode.linkedlist;

import com.xp.java.leetcode.ListNode;
import com.xp.java.util.TestUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @类描述：leetcode445 和 leetcode2 相似
 * 给定俩个链表，计算两个链表之和，给出的链表和leetcode2相反而已
 * @创建人：Wangxiaopan
 * @创建时间：2023/5/6 0006 14:31
 * @修改人：
 * @修改时间：2023/5/6 0006 14:31
 * @修改备注：
 */
public class Solution_0445 {

    public static void main(String[] args) {
        ListNode l1 = getNode(new int[]{7, 2, 4, 3});
        TestUtil.printListNode(l1);
        ListNode l2 = getNode(new int[]{5, 6, 4});
        TestUtil.printListNode(l2);
        TestUtil.printListNode(addTwoNumbers(l1, l2));
    }

    public static ListNode getNode(int[] array) {
        ListNode head = new ListNode(-1);
        return head.getListNode(array);
    }

    //遍历入栈，然后出栈计算，结果拼接链表
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}
