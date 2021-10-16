package com.xp.java.leetcode;

/**
 * @类描述：翻转链表
 * @创建人：Wangxiaopan
 * @创建时间：2018/9/5 0005 10:49
 * @修改人：
 * @修改时间：2018/9/5 0005 10:49
 * @修改备注：
 */
public class Solution_0206 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //就地反转
    public ListNode reverseList(ListNode head) {
        if (null == head) return null;
        if (dummyHead == null) {
            dummyHead = new ListNode(-1);
        }
        dummyHead.next = head;
        ListNode prev = dummyHead.next;
        ListNode pcur = prev.next;
        while (null != pcur) {
            prev.next = pcur.next;
            pcur.next = dummyHead.next;
            dummyHead.next = pcur;
            pcur = prev.next;
        }
        System.out.println(printNode(dummyHead.next));
        return dummyHead.next;
    }

    //使用一个头节点在反转
    public ListNode reverseList2(ListNode head) {
        if (null == head) {
            return null;
        }
        if (dummyHead == null) {
            dummyHead = new ListNode(-1);
        }
        ListNode revert = null;
        while (null != head) {
            ListNode temp = head.next;
            head.next = revert;
            revert = head;
            head = temp;
        }
        System.out.println(printNode(revert));
        return revert;
    }

    ;

    public static void main(String[] args) {
        Solution_0206 solution = new Solution_0206();
        solution.setData();
//        solution.reverseLinkedNode();
//        solution.reverseLinkedNode2();
        solution.reverseList(solution.dummyHead.next);
//        solution.reverseList2(solution.dummyHead.next);
    }

    //因为我这里已经有虚拟头节点了。我就不需要在进行增加虚拟头节点的操作了。
    //这种写法是一个内部置换
    //dummyhead->1->2->3->4->5  prev = 1 pcur = 2  我们要做的是1往后移一位，2放在最前面，用dummyHead来做辅助
    //dummyhead->2->1->3->4->5  prev = 1 pcur = 3  我们要做的是2,1往后移一位，3放在最前面，用dummyHead来做辅助
    public void reverseLinkedNode() {
        ListNode prev = dummyHead.next;
        ListNode pcur = prev.next;
        while (pcur != null) {
            prev.next = pcur.next;
            pcur.next = dummyHead.next;
            dummyHead.next = pcur;
            pcur = prev.next;
        }
        System.out.println(printNode(dummyHead.next));
    }

    //这种方式 我们可以理解为自己添加了一个虚拟头节点，然后不停的在虚拟头节点后面插入新节点，但是他这里没有虚拟头节点而已。
    public void reverseLinkedNode2() {
        ListNode pre = null;
        ListNode head = dummyHead.next;
        while (null != head) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        System.out.println(printNode(pre));
    }

    public void setData() {
        for (int i = 5; i >= 0; i--) {
            addNode(new ListNode(i));
        }
        System.out.println(printNode(dummyHead.next));
    }

    public ListNode dummyHead;

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

    public static String printNode(ListNode node) {
        StringBuilder res = new StringBuilder();
        for (ListNode cur = node; cur != null; cur = cur.next) {
            res.append(cur.val + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
