package com.xp.java.thread.interrupt;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/31 0031 10:48
 * @修改人：
 * @修改时间：2018/10/31 0031 10:48
 * @修改备注：
 */
public class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeedsCleanup = " + id);
    }

    public void cleanup() {
        System.out.println("cleanup " + id);
    }
}
