package com.xp.java.leetcode;

/**
 * @类描述：两数相加
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/27 0027 15:21
 * @修改人：
 * @修改时间：2018/7/27 0027 15:21
 * @修改备注：
 */
public class Solution_0002 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
}
