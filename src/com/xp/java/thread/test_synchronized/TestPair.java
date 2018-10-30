package com.xp.java.thread.test_synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 17:02
 * @修改人：
 * @修改时间：2018/10/30 0030 17:02
 * @修改备注：
 */
public class TestPair {
    public static void main(String[] args) {
        testPair();
    }

    public static void testPair() {
        PairManager manager1 = new PairManager1();
        PairManager manager2 = new PairManager2();
        testPair(manager1, manager2);
    }

    public static void testPair(PairManager manager1, PairManager manager2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator pairManipulator1 = new PairManipulator(manager1);
        PairManipulator pairManipulator2 = new PairManipulator(manager2);

        PairChecker checker1 = new PairChecker(manager1);
        PairChecker checker2 = new PairChecker(manager2);

        exec.execute(pairManipulator1);
        exec.execute(pairManipulator2);
        exec.execute(checker1);
        exec.execute(checker2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("manager1 = " + manager1);
        System.out.println("manager2 = " + manager2);
        System.exit(0);
    }
}
