package com.xp.java.thread.base_simple;

/**
 * 测试线程执行
 * 这个题考察的是 ：
 * sleep不释放锁
 * wait会释放锁
 * notify和notyfyall不会释放锁，只是会唤醒等待的线程，但是锁还是持有在当前同步代码块中，等该代码块执行完毕才会释放锁
 */
public class TestTheadNotify {
    private volatile Object lock = new Object();
    void startThread(final String name,int time) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println("startThread pre wait - " + name);
//                        Thread.sleep(time);
                        lock.wait();
                        System.out.println("thread " + name + " finish");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

    void notifyThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
//                        System.out.println("notifyThread 111");
                        Thread.sleep(1000);
//                        System.out.println("notifyThread 222");
                        lock.notify();
//                        System.out.println("notifyThread 333");
                        Thread.sleep(1000);
                        System.out.println("thread notify finish");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }


    public static void main(String[] args) {
        TestTheadNotify theadNotify = new TestTheadNotify();
        theadNotify.startThread("one",1000);
        theadNotify.startThread("two",1000);
        theadNotify.notifyThread();
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
