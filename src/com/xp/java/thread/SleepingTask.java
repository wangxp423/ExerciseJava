package com.xp.java.thread;

import java.util.concurrent.TimeUnit;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/29 0029 18:10
 * @修改人：
 * @修改时间：2018/10/29 0029 18:10
 * @修改备注：
 */
public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            if (countDown == 0) {
                System.out.println();
            }
            try {
//                Thread.sleep(100);
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
