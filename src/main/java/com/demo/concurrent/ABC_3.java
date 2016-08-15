package com.demo.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年2月29日 上午11:47:15
 * @version V1.0
 */
public class ABC_3 {

    private Semaphore aSemaphore = new Semaphore(1);
    private Semaphore bSemaphore = new Semaphore(0);
    private Semaphore cSemaphore = new Semaphore(0);

    public static void main(String[] args) {
        new ABC_3().setup();
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
        try {
            aSemaphore.acquire();

            System.out.println("A");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            bSemaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
            aSemaphore.release();
        }
    }

    private void printB() {
        try {
            bSemaphore.acquire();

            System.out.println("B");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cSemaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
            bSemaphore.release();
        }
    }

    private void printC() {
        try {
            cSemaphore.acquire();

            System.out.println("C");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            aSemaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
            cSemaphore.release();
        }
    }
}
