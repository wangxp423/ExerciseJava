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

    public static class PrintSynOneRunnable implements Runnable {
        private TestTherad testTheradOne;
        private TestTherad testTheradTwo;

        PrintSynOneRunnable(TestTherad theradOne, TestTherad threadTwo) {
            this.testTheradOne = theradOne;
            this.testTheradTwo = threadTwo;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (testTheradOne) {
                    System.out.print("1");
                    try {
                        testTheradOne.wait();
                        testTheradTwo.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class PrintSynTwoRunnable implements Runnable {
        private TestTherad testTheradOne;
        private TestTherad testTheradTwo;

        PrintSynTwoRunnable(TestTherad theradOne, TestTherad threadTwo) {
            this.testTheradOne = theradOne;
            this.testTheradTwo = threadTwo;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                synchronized (testTheradTwo) {
                    System.out.print("2");
                    try {
                        testTheradTwo.wait();
                        testTheradOne.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestTherad thread = new TestTherad();
        TestTherad threadTwo = new TestTherad();
        ExecutorService exec = Executors.newCachedThreadPool();
//        exec.execute(new PrintOneRunnable(thread));
//        exec.execute(new PrintTwoRunnable(thread));
        exec.execute(new PrintSynOneRunnable(thread, threadTwo));
        exec.execute(new PrintSynTwoRunnable(thread, threadTwo));
        TimeUnit.MILLISECONDS.sleep(15);
        exec.shutdownNow();
    }
}
