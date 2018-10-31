package com.xp.java.thread.pipe;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.concurrent.TimeUnit;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/31 0031 16:00
 * @修改人：
 * @修改时间：2018/10/31 0031 16:00
 * @修改备注：
 */
public class Sender implements Runnable {
    private PipedWriter out = new PipedWriter();

    public PipedWriter getPipedWriter() {
        return out;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'Z'; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(150);
                }
            }
        } catch (IOException e) {
            System.out.println("Sender IOException");
        } catch (InterruptedException e) {
            System.out.println("Sender InterruptedException");
        }
    }
}
