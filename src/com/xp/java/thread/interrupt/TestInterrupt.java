package com.xp.java.thread.interrupt;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/31 0031 10:48
 * @修改人：
 * @修改时间：2018/10/31 0031 10:48
 * @修改备注：
 */
public class TestInterrupt {
    //当你在线程上调用interrupt()时，中断发生的唯一时刻是在任务要进入到阻塞操作中或者已经进入阻塞中
    //但是I/O或者被阻塞的synchronized方法除外。
    public static void main(String[] args) throws InterruptedException {
        testBlocked3();
    }

    //该测试强调在你经由异常离开循环时，正确清理资源的必要性。
    //可以通过使用不同的延迟就可以在不同的地点退出Block3.run
    //如果我们不设置延迟，那么while循环将进不去。
    //被设计用来相应interrupt的类必须建立一种策略，来确保他将保持一致的状态。
    //这通常意味着所有需要清理的对象创建操作后面必须紧跟try-finally。从而保证无论run何时退出都会执行清理。
    public static void testBlocked3() throws InterruptedException {
        Thread t = new Thread(new Blocked3());
        t.start();
//        TimeUnit.SECONDS.sleep(2);
        t.interrupt();
    }
}
