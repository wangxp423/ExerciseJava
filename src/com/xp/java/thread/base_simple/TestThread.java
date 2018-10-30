package com.xp.java.thread.base_simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
//        testPriorities();
//        testDaemons();
//        testDaemonFactory();
//        testThreadIsDaemons();
//        testExtendThread();
//        testSelfManager();
        testThreadException();
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
        System.out.println("all Thread started");
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

    public static void testPriorities() {
        //只是倾向于让优先级高的先运行而已。并不是一定。
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        service.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        service.shutdown();
    }

    public static void testDaemons() {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("all daemons started");
        System.out.println("currentThread = " + Thread.currentThread());
        //main设置睡眠 所以可以观察到后台线程执行
        //不然的话当 main运行完毕 后台线程自动终止 就看不到运行了。
        try {
            TimeUnit.MILLISECONDS.sleep(175);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testDaemonFactory() {
        //这里其实是通过ThreadFactory来设置 Thread的一些属性。
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("all daemons started");
        System.out.println("currentThread = " + Thread.currentThread());
        try {
            TimeUnit.MILLISECONDS.sleep(175);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testThreadIsDaemons() {
        //Daemon线程被设置成了后台线程，那么他派生出来许多子线程 这些线程也都是后台模式。
        //后台线程 我们会发现他并不执行finally里面的内容 当非后台线程运行完毕，所有后台线程立马终止
        //但是如果你不将线程设置为daemon 那么finally语句将会执行。
        Thread thread = new Thread(new Daemon());
        thread.setDaemon(true);
        thread.start();
        System.out.println("thread.isDaemon = " + thread.isDaemon());
        System.out.println("currentThread = " + Thread.currentThread());
        try {
            TimeUnit.MILLISECONDS.sleep(175);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testExtendThread() {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }

    public static void testSelfManager() {
        for (int i = 0; i < 5; i++) {
            new SelfManager();
        }
    }

    public static void testThreadException() {
        long start = System.currentTimeMillis();
        ExecutorService exec = Executors.newCachedThreadPool(new ExceptionThread.HandlerThreadFactory());
        exec.execute(new ExceptionThread());
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));
    }
}
