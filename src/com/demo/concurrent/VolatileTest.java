package com.demo.concurrent;


/**
 * @author qingbao.ho@gmail.com
 * @date 2016年2月29日 下午5:58:23
 * @version V1.0
 */
public class VolatileTest {

    private volatile static int count = 0;

    public static void inc() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    VolatileTest.inc();
                }
            }).start();
        }

        System.out.println("运行结果:count=" + count);
    }

}
