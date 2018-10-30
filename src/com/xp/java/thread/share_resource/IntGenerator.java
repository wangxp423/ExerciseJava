package com.xp.java.thread.share_resource;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 14:46
 * @修改人：
 * @修改时间：2018/10/30 0030 14:46
 * @修改备注：
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
