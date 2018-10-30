package com.xp.java.thread.base_simple;

import java.util.concurrent.ThreadFactory;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 11:41
 * @修改人：
 * @修改时间：2018/10/30 0030 11:41
 * @修改备注：
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("Excetpion = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }


    public static class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("caught = " + t + " Exception = " + e);
        }
    }

    public static class HandlerThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            System.out.println("creating new Thread = " + this);
            Thread thread = new Thread(r);
            thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            System.out.println("factory exception = " + thread.getUncaughtExceptionHandler());
            return thread;
        }
    }
}
