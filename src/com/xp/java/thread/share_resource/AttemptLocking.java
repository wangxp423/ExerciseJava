package com.xp.java.thread.share_resource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 16:02
 * @修改人：
 * @修改时间：2018/10/30 0030 16:02
 * @修改备注：
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) lock.unlock();
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        try {
            System.out.println("tryLock(2,TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) lock.unlock();
        }
    }
}
