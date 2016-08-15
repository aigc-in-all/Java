package com.demo.concurrent;

import java.util.Vector;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月8日 上午11:00:06
 * @version V1.0
 * 
 * http://java67.blogspot.jp/2012/12/producer-consumer-problem-with-wait-and-notify-example.html
 */
public class ProducerConsumerSolution1 {

    public static void main(String[] args) {
        Vector<Integer> sharedQueue = new Vector<>();
        int size = 4;

        Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");

        prodThread.start();
        consThread.start();
    }
}

class Producer implements Runnable {

    private final Vector<Integer> sharedQueue;
    private final int SIZE;

    public Producer(Vector<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Produced: " + i);

            try {
                produce(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {

        // wait if queue is full
        while (sharedQueue.size() == SIZE) {
            synchronized (sharedQueue) {
                System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + sharedQueue.size());
                sharedQueue.wait();
            }
        }

        // producing element and notify consumers
        synchronized (sharedQueue) {
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}

class Consumer implements Runnable {

    private final Vector<Integer> sharedQueue;
    private final int SIZE;

    public Consumer(Vector<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int consume() throws InterruptedException {
        // wait if queue is empty
        while (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {
                System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + sharedQueue.size());
                sharedQueue.wait();
            }
        }

        // Otherwise consume element and notify waiting producer
        synchronized (sharedQueue) {
            sharedQueue.notifyAll();
            return sharedQueue.remove(0);
        }
    }
}
