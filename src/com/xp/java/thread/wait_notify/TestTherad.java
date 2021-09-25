package com.xp.java.thread.wait_notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//开启两个线程 依次输入12121212
public class TestTherad {
    private boolean isOnePrint = true;

    public synchronized void change() {
        if (isOnePrint) {
            isOnePrint = false;
        } else {
            isOnePrint = true;
        }
    }

    public synchronized void printOne() {
        while (!Thread.interrupted()) {
            try {
                if (isOnePrint) {
                    System.out.print("1");
                    change();
                    notifyAll();
                } else {
                    wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void printTwo() {
        while (!Thread.interrupted()) {
            try {
                if (!isOnePrint) {
                    System.out.print("2");
                    change();
                    notifyAll();
                } else {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class PrintOneRunnable implements Runnable {
        private TestTherad testTherad;

        PrintOneRunnable(TestTherad therad) {
            this.testTherad = therad;
        }

        @Override
        public void run() {
            testTherad.printOne();
        }
    }

    public static class PrintTwoRunnable implements Runnable {
        private TestTherad testTherad;

        PrintTwoRunnable(TestTherad therad) {
            this.testTherad = therad;
        }

        @Override
        public void run() {
            testTherad.printTwo();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestTherad thread = new TestTherad();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new PrintOneRunnable(thread));
        exec.execute(new PrintTwoRunnable(thread));
        TimeUnit.MILLISECONDS.sleep(5);
        exec.shutdownNow();
    }
}
