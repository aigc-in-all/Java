package com.demo.concurrent;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月8日 下午1:47:35
 * @version V1.0
 */
public class NotifyTest {
    private Object lock = new Object();
    private boolean b = true;

    class NotifyThread extends Thread {
        public NotifyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                b = false;
                // lock.notifyAll();
                lock.notify();
            }
        }
    };

    class WaitThread extends Thread {
        public WaitThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (b) {
                    System.out.println(getName() + " begin waiting!");
                    long waitTime = System.currentTimeMillis();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    waitTime = System.currentTimeMillis() - waitTime;
                    System.out.println("wait time :" + waitTime);
                }
                System.out.println(getName() + " end waiting!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Run!");
        NotifyTest test = new NotifyTest();
        NotifyThread notifyThread = test.new NotifyThread("notify01");
        WaitThread waitThread01 = test.new WaitThread("waiter01");
        WaitThread waitThread02 = test.new WaitThread("waiter02");
        WaitThread waitThread03 = test.new WaitThread("waiter03");
        notifyThread.start();
        waitThread01.start();
        waitThread02.start();
        waitThread03.start();
    }
}
