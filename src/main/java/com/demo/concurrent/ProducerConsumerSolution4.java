package com.demo.concurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月8日 下午12:26:51
 * @version V1.0
 */
public class ProducerConsumerSolution4 {

    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>(5);

        Producer p = new Producer(sharedQueue);
        Consumer c = new Consumer(sharedQueue);

        p.start();
        c.start();
    }

    static class Producer extends Thread {

        private final BlockingQueue<Integer> sharedQueue;
        
        private final Random random = new Random();

        public Producer(BlockingQueue<Integer> sharedQueue) {
            super("PRODUCER");
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Integer obj = random.nextInt();
                    sharedQueue.put(obj);
                    System.out.println(Thread.currentThread().getName() + " 生产数据:" + obj + ", 总共:" + sharedQueue.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {

        private final BlockingQueue<Integer> sharedQueue;

        public Consumer(BlockingQueue<Integer> sharedQueue) {
            super("CONSUMER");
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Integer obj = sharedQueue.take();
                    System.out.println(Thread.currentThread().getName() + " 消费数据:" + obj + ", 剩余:" + sharedQueue.size());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
