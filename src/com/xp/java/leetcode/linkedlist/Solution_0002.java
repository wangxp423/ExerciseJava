package com.xp.java.leetcode.linkedlist;

import com.xp.java.leetcode.ListNode;
import com.xp.java.util.TestUtil;

/**
 * @类描述：leetcode2 两数相加
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/27 0027 15:21
 * @修改人：
 * @修改时间：2018/7/27 0027 15:21
 * @修改备注：
 */
public class Solution_0002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode one = l1;
        ListNode two = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (one != null || two != null) {
            int oneVal = one == null ? 0 : one.val;
            int twoVal = two == null ? 0 : two.val;
            int sum;
            sum = carry + oneVal + twoVal;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (null != one) one = one.next;
            if (null != two) two = two.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode twoNunbersSum(ListNode node1, ListNode node2) {
        ListNode one = node1, two = node2;
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        int carry = 0;
        while (null != one || null != two) {
            int oneVal = null == one ? 0 : one.val;
            int twoVal = null == two ? 0 : two.val;
            int sum = carry + oneVal + twoVal;
            carry = sum / 10;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
            if (null != one) one = one.next;
            if (null != two) two = two.next;
        }
        if (carry > 0) {
            curNode.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = ListNode.array2ListNode(new int[]{2, 4, 3});
        ListNode node2 = ListNode.array2ListNode(new int[]{9, 1, 9});
        TestUtil.printListNode(node1);
        TestUtil.printListNode(node2);
        TestUtil.printListNode(addTwoNumbers(node1, node2));
        TestUtil.printListNode(twoNunbersSum(node1, node2));
    }
}
