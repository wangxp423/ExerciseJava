package com.xp.java.thread.share_resource;

import java.util.Random;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/30 0030 14:58
 * @修改人：
 * @修改时间：2018/10/30 0030 14:58
 * @修改备注：
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    private Random random = new Random();

    @Override
    public int next() {
        currentEvenValue = random.nextInt(99);
        System.out.println("random = " + currentEvenValue);
        return currentEvenValue;
    }
}
