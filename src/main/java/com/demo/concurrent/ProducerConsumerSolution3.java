package com.demo.concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月8日 下午12:26:51
 * @version V1.0
 */
public class ProducerConsumerSolution3 {

    public static void main(String[] args) {
        ProducerConsumerImpl impl = new ProducerConsumerImpl();

        Producer p = new Producer(impl);
        Consumer c = new Consumer(impl);

        p.start();
        c.start();
    }

    static class ProducerConsumerImpl {
        private static final int CAPACITY = 10;
        private final Queue<Integer> queue = new LinkedList<>();
        private final Random random = new Random();

        private final Lock lock = new ReentrantLock();
        private final Condition notFull = lock.newCondition();
        private final Condition notEmpty = lock.newCondition();

        public void put() throws InterruptedException {
            lock.lock();
            try {
                while (queue.size() == CAPACITY) {
                    System.out.println(Thread.currentThread().getName() + " 数据是满的，等待消费...");
                    notEmpty.await();
                }

                int number = random.nextInt();
                boolean isAdded = queue.offer(number);
                if (isAdded) {
                    System.out.println(Thread.currentThread().getName() + " 生产数据:" + number + ", 总共:" + queue.size());
                    notFull.signalAll();
                }

            } finally {
                lock.unlock();
            }
        }

        public void get() throws InterruptedException {
            lock.lock();
            try {
                while (queue.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + " 数据为空，等待生产...");
                    notFull.await();
                }

                Integer value = queue.poll();
                if (value != null) {
                    System.out.println(Thread.currentThread().getName() + " 消费数据:" + value + ", 剩余:" + queue.size());
                    notEmpty.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    static class Producer extends Thread {

        private ProducerConsumerImpl pc;

        public Producer(ProducerConsumerImpl pc) {
            super("PRODUCER");
            this.pc = pc;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    pc.put();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {

        private ProducerConsumerImpl pc;

        public Consumer(ProducerConsumerImpl pc) {
            super("CONSUMER");
            this.pc = pc;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    pc.get();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
