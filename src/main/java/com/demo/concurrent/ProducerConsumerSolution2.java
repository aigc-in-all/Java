package com.demo.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月8日 下午12:26:51
 * @version V1.0
 */
public class ProducerConsumerSolution2 {

    private static List<Integer> shareData = new ArrayList<>();
    private static final int SIZE = 4;

    public static void main(String[] args) {
        Thread prodThread = new Thread(new Producer(), "Producer");
        Thread consThread = new Thread(new Consumer(), "Consumer");

        prodThread.start();
        consThread.start();
    }

    static class Producer implements Runnable {

        private Random random = new Random();

        @Override
        public void run() {
            while (true) {
                synchronized (shareData) {
                    while (shareData.size() == SIZE) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " 数据是满的，等待消费...");
                            shareData.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    Integer obj = random.nextInt(100);
                    shareData.add(obj);
                    System.out.println(Thread.currentThread().getName() + " 生产数据:" + obj + ", 总共:" + shareData.size());

                    shareData.notifyAll();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (shareData) {
                    while (shareData.isEmpty()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " 数据为空，等待生产...");
                            shareData.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    Integer obj = shareData.get(0);
                    shareData.remove(obj);
                    System.out.println(Thread.currentThread().getName() + " 消费数据:" + obj + ", 剩余:" + shareData.size());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    shareData.notifyAll();
                }
            }
        }
    }
}
