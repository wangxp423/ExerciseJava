package com.xp.java.thread.test_synchronized;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 16:54
 * @修改人：
 * @修改时间：2018/10/30 0030 16:54
 * @修改备注：
 */
public class PairManager1 extends PairManager {

    //有兴趣的也可以用Lock来实现以下
    public synchronized void increment() {
        //我们需要在线程不安全的地方加上同步
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
