package com.xp.java.thread.test_synchronized;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 16:57
 * @修改人：
 * @修改时间：2018/10/30 0030 16:57
 * @修改备注：
 */
public class PairManipulator implements Runnable {
    private PairManager manager;

    public PairManipulator(PairManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            manager.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair = " + manager.getPair() + " checkCounter = " + manager.checkCount.get();
    }
}
