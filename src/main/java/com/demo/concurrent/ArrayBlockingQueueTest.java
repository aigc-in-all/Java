package com.demo.concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年2月29日 下午2:40:25
 * @version V1.0
 */
public class ArrayBlockingQueueTest {

    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

    private CountDownLatch produCountDownLatch;
    private CountDownLatch consumerCountDownLatch;

    public static void main(String[] args) {
        new ArrayBlockingQueueTest().test();
    }

    public void test() {
        produCountDownLatch = new CountDownLatch(10);
        consumerCountDownLatch = new CountDownLatch(10);

        Thread t1 = new Thread(new ProducerTask());
        Thread t2 = new Thread(new ConsumerTask());

        t1.start();
        t2.start();

        try {
            System.out.println("producer waiting...");
            produCountDownLatch.await();
            System.out.println("producer end");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("consumer waiting...");
            consumerCountDownLatch.await();
            System.out.println("consumer end");
        } catch (Exception e) {
            e.printStackTrace();
        }

        t1.interrupt();
        t2.interrupt();

        System.out.println("end");
    }

    class ProducerTask implements Runnable {

        private Random rnd = new Random();

        @Override
        public void run() {
            while (true) {
                try {
                    Integer value = rnd.nextInt(1000);
                    queue.put(value);
                    System.out.println("生产数据：" + value);
                    produCountDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ConsumerTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Integer value = queue.take();
                    System.out.println("消费数据 : " + value);
                    consumerCountDownLatch.countDown();
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
