package com.xp.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/29 0029 17:36
 * @修改人：
 * @修改时间：2018/10/29 0029 17:36
 * @修改备注：
 */
public class TestThread {
    public static void main(String[] args) {
//        newLiftOff();
//        testThread();
//        testMoreThread();
//        testCacheThreadPool();
//        testFixedThreadPool();
//        testSingleThreadExecutor();
//        testSleepThread();
        testPriorities();
    }

    public static void newLiftOff() {
        LiftOff off = new LiftOff();
        off.run();
    }

    public static void testThread() {
        Thread thread = new Thread(new LiftOff());
        thread.start();
    }

    public static void testMoreThread() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.start();
        }
    }

    public static void testCacheThreadPool() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
    }

    public static void testFixedThreadPool() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
    }

    public static void testSingleThreadExecutor() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
    }

    public static void testSleepThread() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new SleepingTask());
        }
        service.shutdown();
    }

    public static void testPriorities() { //694
        //只是倾向于让优先级高的先运行而已。并不是一定。
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        service.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        service.shutdown();
    }
}
