package com.xp.java.thread.wait_notify;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/31 0031 11:35
 * @修改人：
 * @修改时间：2018/10/31 0031 11:35
 * @修改备注：
 */
public class Car {
    //《java编程思想》744通过Lock 和  Condition实现
    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn == true) {
            wait();
        }
    }
}
