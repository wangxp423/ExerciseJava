package com.xp.java.thread.base_simple;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 10:53
 * @修改人：
 * @修改时间：2018/10/30 0030 10:53
 * @修改备注：
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "#" + getName() + "(" + countDown + ")";
    }
}
