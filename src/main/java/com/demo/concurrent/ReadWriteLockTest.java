package com.demo.concurrent;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年2月29日 下午1:00:29
 * @version V1.0
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        final Queue3 q3 = new Queue3();
        for (int i = 0; i < 3; i++) {
            new Thread("Read Thread-" + i) {
                @Override
                public void run() {
                    while (true) {
                        q3.get();
                    }
                }

            }.start();

            new Thread("Write Thread-" + i) {
                @Override
                public void run() {
                    while (true) {
                        q3.put(new Random().nextInt(10000));
                    }
                }

            }.start();
        }
    }

    private static class Queue3 {
        private Object data = null;
        ReadWriteLock rwl = new ReentrantReadWriteLock();

        public void get() {
            rwl.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " is ready to read data");
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + " has been read data : " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
        }

        public void put(Object data) {
            rwl.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " is ready to write data");
                Thread.sleep((long) (Math.random() * 1000));
                this.data = data;
                System.out.println(Thread.currentThread().getName() + " has been write data : " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.writeLock().unlock();
            }
        }
    }
}
