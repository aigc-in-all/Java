package com.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VerifyHostTask {

    private static VerifyHostTask instance;

    private ScheduledExecutorService scheduleExecutorService;

    private ExecutorService executorService;
    private Future<?> future;

    private long lastCheckTime;

    private VerifyHostTask() {}

    public static VerifyHostTask getInstance() {
        if (instance == null) {
            instance = new VerifyHostTask();
        }
        return instance;
    }

    public void start() {
        if (scheduleExecutorService == null) {
            scheduleExecutorService = Executors.newSingleThreadScheduledExecutor();
        }

        scheduleExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("schedule");
                checkServers("schedule");
            }
        }, 1, 5, TimeUnit.SECONDS);
    }

    public void check() {
        if (executorService == null) {
            executorService = Executors.newSingleThreadExecutor();
        }

        if (future != null && !future.isDone()) {
            return;
        }

        future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                checkServers("check");
            }
        });
    }

    public void shutdown() {
        if (scheduleExecutorService != null) {
            scheduleExecutorService.shutdown();
            scheduleExecutorService = null;
        }

        if (executorService != null) {
            executorService.shutdown();
            executorService = null;
        }
    }

    private synchronized void checkServers(String s) {
        System.out.println("checkServers:" + s);
        if (System.currentTimeMillis() - lastCheckTime < 3 * 1000) {
            System.out.println("return:" + s);
            return;
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lastCheckTime = System.currentTimeMillis();
    }
}
