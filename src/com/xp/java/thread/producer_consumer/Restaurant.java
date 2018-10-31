package com.xp.java.thread.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/31 0031 15:18
 * @修改人：
 * @修改时间：2018/10/31 0031 15:18
 * @修改备注：
 */
public class Restaurant {
    public Meal meal;
    public WaitPerson waitPerson = new WaitPerson(this);
    public Chef chef = new Chef(this);
    ExecutorService exec = Executors.newCachedThreadPool();

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    //《java编程思想》746通过同步队列，实现生产者和消费者
    //这个示例  通过Restaurant作为一个媒介，分别通过waitPerson和Chef两个锁来同步Meal
    public static void main(String[] args) {
        new Restaurant();
    }
}
