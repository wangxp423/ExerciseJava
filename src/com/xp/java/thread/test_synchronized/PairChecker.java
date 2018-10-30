package com.xp.java.thread.test_synchronized;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 17:01
 * @修改人：
 * @修改时间：2018/10/30 0030 17:01
 * @修改备注：
 */
public class PairChecker implements Runnable {
    private PairManager manager;

    public PairChecker(PairManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
//            System.out.println("checkCount = " + manager.checkCount);
            int count = manager.checkCount.incrementAndGet();
//            System.out.println("incrementAndGet = " + count);
            manager.getPair().checkStatus();
        }
    }
}
