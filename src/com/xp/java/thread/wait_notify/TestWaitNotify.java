package com.xp.java.thread.wait_notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/31 0031 11:28
 * @修改人：
 * @修改时间：2018/10/31 0031 11:28
 * @修改备注：
 */
public class TestWaitNotify {
    //wait()是你可以在等待某个条件发生变化，而改变这个条件超出了当前方法的控制范围
    //wait可以在等待外部世界发生变化的时候将任务挂起，避免不断进行空循环这被称为忙等待而消耗CPU资源
    //1，在wait期间对象锁是释放的
    //2，可以通过notify，notifyall或者令时间到期从wait中恢复过来。
    //3，wait,notify,notifyall是Object基类的方法。而不是Thread的一部分
    public static void main(String[] args) throws InterruptedException {
        testCarWax();
    }

    public static void testCarWax() throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}
