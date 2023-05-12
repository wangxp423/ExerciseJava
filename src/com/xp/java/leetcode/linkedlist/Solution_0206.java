package com.xp.java.leetcode.linkedlist;

import com.xp.java.leetcode.ListNode;
import com.xp.java.util.TestUtil;

/**
 * @类描述：leetcode206 翻转链表
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/5 0005 10:49
 * @修改人：
 * @修改时间：2018/9/5 0005 10:49
 * @修改备注：
 */
public class Solution_0206 {

    //就地反转
    public static ListNode reverseList(ListNode head) {
        if (null == head) return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead.next;
        ListNode pcur = prev.next;
        while (null != pcur) {
            prev.next = pcur.next;
            pcur.next = dummyHead.next;
            dummyHead.next = pcur;
            pcur = prev.next;
        }
        return dummyHead.next;
    }

    //新建一个链表反转
    public static ListNode reverseList2(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode revert = null;
        while (null != head) {
            ListNode temp = head.next;
            head.next = revert;
            revert = head;
            head = temp;
        }
        return revert;
    }

    //因为我这里已经有虚拟头节点了。我就不需要在进行增加虚拟头节点的操作了。
    //这种写法是一个内部置换
    //dummyhead->1->2->3->4->5  prev = 1 pcur = 2  我们要做的是1往后移一位，2放在最前面，用dummyHead来做辅助
    //dummyhead->2->1->3->4->5  prev = 1 pcur = 3  我们要做的是2,1往后移一位，3放在最前面，用dummyHead来做辅助
    public static ListNode reverseLinkedNode(ListNode node) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = node;
        ListNode prev = dummyHead.next;
        ListNode pcur = prev.next;
        while (pcur != null) {
            prev.next = pcur.next;
            pcur.next = dummyHead.next;
            dummyHead.next = pcur;
            pcur = prev.next;
        }
        return dummyHead.next;
    }

    //这种方式 我们可以理解为自己添加了一个虚拟头节点，然后不停的在虚拟头节点后面插入新节点，但是他这里没有虚拟头节点而已。
    public static ListNode reverseLinkedNode2(ListNode node) {
        ListNode pre = null;
        while (null != node) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.array2ListNode(new int[]{5, 4, 3, 2, 1});
        TestUtil.printListNode(node);

//        ListNode node1 = reverseLinkedNode(node);
//        TestUtil.printListNode(node1);
//
//        ListNode node2 = reverseLinkedNode2(node);
//        TestUtil.printListNode(node2);
//
//        ListNode node3 = reverseList(node);
//        TestUtil.printListNode(node3);
//
        ListNode node4 = reverseList2(node);
        TestUtil.printListNode(node4);

    }

}
