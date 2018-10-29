package com.xp.java.thread;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/29 0029 17:32
 * @修改人：
 * @修改时间：2018/10/29 0029 17:32
 * @修改备注：
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            if (countDown == 0) {
                System.out.println();
            }
            Thread.yield();//线程调度，切换线程
        }
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ")，";
    }
}
