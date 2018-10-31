package com.xp.java.thread.producer_consumer;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/31 0031 15:05
 * @修改人：
 * @修改时间：2018/10/31 0031 15:05
 * @修改备注：
 */
public class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal : " + orderNum;
    }
}
