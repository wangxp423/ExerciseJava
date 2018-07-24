package com.xp.java.datastructures.linked;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/23 0023 16:47
 * @修改人：
 * @修改时间：2018/7/23 0023 16:47
 * @修改备注：
 */
public class TestLinkedList {
    public static void main(String[] args) {
//        testLinkedList();
//        testLinkedListStack();
//        testLinkedListQueue();
        testLinkedListQueue1();
    }

    private static void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeElement(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }

    private static void testLinkedListStack() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }

    private static void testLinkedListQueue() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    private static void testLinkedListQueue1() {
        LinkedListQueue1<Integer> queue = new LinkedListQueue1<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

//            if(i % 3 == 2){
//                queue.dequeue();
//                System.out.println(queue);
//            }
        }
    }
}
