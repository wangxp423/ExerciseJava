package com.xp.java.stack_queues.queues;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/20 0020 14:53
 * @修改人：
 * @修改时间：2018/7/20 0020 14:53
 * @修改备注：
 */
public class TestQueue {
    public static void main(String[] args) {
//        testArrayQueue();
        testLoopQueue();
    }

    private static void testArrayQueue() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    private static void testLoopQueue() {
        LoopQueue<Integer> queue = new LoopQueue<>(5);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
