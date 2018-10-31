package com.xp.java.thread.pipe;

import java.io.IOException;
import java.io.PipedReader;

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/10/31 0031 16:03
 * @修改人：
 * @修改时间：2018/10/31 0031 16:03
 * @修改备注：
 */
public class Receiver implements Runnable {
    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Read = " + (char) in.read());
            }
        } catch (IOException e) {
            System.out.println("Receiver IOException");
        }
    }
}
