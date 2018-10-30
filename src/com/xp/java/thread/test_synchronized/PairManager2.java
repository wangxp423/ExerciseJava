package com.xp.java.thread.test_synchronized;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 16:56
 * @修改人：
 * @修改时间：2018/10/30 0030 16:56
 * @修改备注：
 */
public class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementY();
            p.incrementX();
            temp = getPair();
        }
        store(temp);
    }
}
