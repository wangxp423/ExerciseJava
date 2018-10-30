package com.xp.java.thread.base_simple;

import java.util.concurrent.TimeUnit;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 10:06
 * @修改人：
 * @修改时间：2018/10/30 0030 10:06
 * @修改备注：
 */
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                System.out.print("sleep() interrupted");
                e.printStackTrace();
            }
        }
    }
}
