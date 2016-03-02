package com.demo.concurrent;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年2月29日 上午10:37:15
 * @version V1.0
 */
public class ABC_1 {

    private int status = 0;

    public static void main(String[] args) {
        new ABC_1().setup();
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

    private synchronized void printA() {
        while (status % 3 != 0) {
            try {
                this.wait();
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
        this.notifyAll();
    }

    private synchronized void printB() {
        while (status % 3 != 1) {
            try {
                this.wait();
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
        this.notifyAll();
    }

    private synchronized void printC() {
        while (status % 3 != 2) {
            try {
                this.wait();
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
        this.notifyAll();
    }
}
