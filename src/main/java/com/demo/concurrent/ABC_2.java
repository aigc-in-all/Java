package com.demo.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年2月29日 上午11:47:15
 * @version V1.0
 */
public class ABC_2 {

    private Lock lock = new ReentrantLock();

    private Condition aCondition = lock.newCondition();
    private Condition bCondition = lock.newCondition();
    private Condition cCondition = lock.newCondition();

    private int status = 0;

    public static void main(String[] args) {
        new ABC_2().setup();
    }

    private void setup() {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    printA();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    printB();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    printC();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    private void printA() {
        lock.lock();
        try {
            while (status % 3 != 0) {
                try {
                    aCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("A");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            status++;
            bCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void printB() {
        lock.lock();
        try {
            while (status % 3 != 1) {
                try {
                    bCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("B");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            status++;
            cCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void printC() {
        lock.lock();
        try {
            while (status % 3 != 2) {
                try {
                    cCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("C");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            status++;
            aCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
