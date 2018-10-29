package com.xp.java.thread;

import java.util.concurrent.Callable;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/29 0029 17:55
 * @修改人：
 * @修改时间：2018/10/29 0029 17:55
 * @修改备注：
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "TaskWithResult id is = " + id;
    }
}
