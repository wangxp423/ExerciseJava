package com.xp.java.thread.share_resource;

/**
 * @类描述：测试总类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 14:59
 * @修改人：
 * @修改时间：2018/10/30 0030 14:59
 * @修改备注：
 */
public class TestResource {
    //原子性的操作可以应用于除long double之外的所有基本数据类型。
    public static void main(String[] args) {
//        testEvenGenerator();
//        testSynchronizedEvenGenerator();
//        testLockEvenGenerator();
        testLocking();
    }

    public static void testEvenGenerator() {
        //我们发现 当调用随机数，多试几次。可能会出现已经cancel了。但是方法依旧进来了
        //这就是在资源使用的时候 出现的问题。
        //因为在随机数产生的过程也是有很多个步骤。可以参考java原子性操作的几个步骤。
        //如果不能保证原子性，在数字赋值的时候就会存在资源不一致问题。
        EvenChecker.test(new EvenGenerator());
    }

    public static void testSynchronizedEvenGenerator() {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }

    public static void testLockEvenGenerator() {
        EvenChecker.test(new LockEvenGenerator());
    }

    public static void testLocking() {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
    }
}
