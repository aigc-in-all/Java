package com.demo.concurrent;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月1日 下午2:21:38
 * @version V1.0
 *
 * 解释它之前，先简述下，多线程的执行流程：多个线程并发请求执行时，由cpu决定优先执行哪一个，即使通过thread.setPriority()，设置了 线程的优先级，也不一定就是每次都先执行它
 * yield，表示暂停当前线程，执行其他线程(包括自身线程) 由cpu决定
 */
public class YieldTest implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        YieldTest run = new YieldTest();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);

        t2.setPriority(t2.getPriority() + 1);
        t1.start();
        t2.start();
        t3.start();
    }
}
