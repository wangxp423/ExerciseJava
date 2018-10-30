package com.xp.java.thread.base_simple;

import java.util.concurrent.ThreadFactory;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 10:30
 * @修改人：
 * @修改时间：2018/10/30 0030 10:30
 * @修改备注：
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
