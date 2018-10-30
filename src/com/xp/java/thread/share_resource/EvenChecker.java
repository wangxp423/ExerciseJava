package com.xp.java.thread.share_resource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 14:47
 * @修改人：
 * @修改时间：2018/10/30 0030 14:47
 * @修改备注：
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        this.generator = g;
        id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
//            synchronized (this){ //这里加同步 可以避免 出现问题。
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
//            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-c to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
