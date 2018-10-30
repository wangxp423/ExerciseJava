package com.xp.java.thread.base_simple;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/29 0029 17:57
 * @修改人：
 * @修改时间：2018/10/29 0029 17:57
 * @修改备注：
 */
public class TestCallable {
    public static void main(String[] args) {
        testResult();
    }

    public static void testResult() {
        //submit 产生Future对象
        //callable返回结果的特定类型进行了参数化
        //可以用isDone()方法查询Future是否完成
        //也可以直接用get()获取结果，这种情况下get将阻塞，直到结果准备就绪
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
