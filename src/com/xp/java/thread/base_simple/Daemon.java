package com.xp.java.thread.base_simple;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 10:39
 * @修改人：
 * @修改时间：2018/10/30 0030 10:39
 * @修改备注：
 */
public class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon = " + t[i].isDaemon() + "，");
        }
        while (true) Thread.yield();
    }
}
