package com.xp.java.thread.test_synchronized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 16:48
 * @修改人：
 * @修改时间：2018/10/30 0030 16:48
 * @修改备注：
 */
public abstract class PairManager {
    AtomicInteger checkCount = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }

    protected void store(Pair p) {
//        System.out.println("store.x = " + p.getX() + " store.y = " + p.getY());
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increment();
}
