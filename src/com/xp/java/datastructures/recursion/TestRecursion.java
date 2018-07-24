package com.xp.java.datastructures.recursion;

/**
 * @类描述：测试 递归
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/24 0024 11:33
 * @修改人：
 * @修改时间：2018/7/24 0024 11:33
 * @修改备注：
 */
public class TestRecursion {
    public static void main(String[] args) {
//        testListNode();
//        testNormal();
        testRecursion();
    }

    private static void testListNode() {
        int[] data = {1, 2, 6, 3, 4, 5, 6};
        ListNode node = new ListNode(data);
        System.out.println(node);
    }

    private static void testNormal() {
        //测试常规遍历
        int[] data = {1, 2, 6, 3, 4, 5, 6};
        ListNode node = new ListNode(data);
        System.out.println(Leetcode203.removeElements(node, 6));
    }

    private static void testRecursion() {
        //测试常规遍历
        int[] data = {1, 2, 6, 3, 4, 5, 6};
        ListNode node = new ListNode(data);
        System.out.println(Leetcode203.removeElements1(node, 6));
    }
}
