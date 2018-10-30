package com.xp.java.thread.share_resource;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 15:42
 * @修改人：
 * @修改时间：2018/10/30 0030 15:42
 * @修改备注：
 */
public class LockEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    private Random random = new Random();
    private Lock lock = new ReentrantLock();

    public synchronized int next() {
        //我们发现在这里加了同步锁  但是在后面获取值 计算的时候还是有同步问题
        lock.lock();
        try {
            currentEvenValue = random.nextInt(99);
            System.out.println("random = " + currentEvenValue);
            return currentEvenValue;
        } finally {
            lock.unlock();
        }

    }
}
