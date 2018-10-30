package com.xp.java.thread.base_simple;

/**
 * @类描述：管理自己的线程
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 11:05
 * @修改人：
 * @修改时间：2018/10/30 0030 11:05
 * @修改备注：
 */
public class SelfManager implements Runnable {
    private int countDown = 5;
    private Thread thread = new Thread(this);

    public SelfManager() {
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + ")";
    }
}
