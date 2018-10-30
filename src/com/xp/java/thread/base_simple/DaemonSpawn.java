package com.xp.java.thread.base_simple;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 10:40
 * @修改人：
 * @修改时间：2018/10/30 0030 10:40
 * @修改备注：
 */
public class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
