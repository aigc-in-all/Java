package com.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CopyOfDemo {

    private static ScheduledExecutorService primaryScheduleExecutorService = Executors.newSingleThreadScheduledExecutor();
    private static ScheduledFuture future;

    public static void main(String[] args) throws Exception {

        Runnable r = new Runnable() {

            @Override
            public void run() {
                System.out.println("hello1");
            }
        };

        for (int i = 0; i < 10; i++) {
            //
        }

        future = primaryScheduleExecutorService.scheduleWithFixedDelay(r, 0, 2, TimeUnit.SECONDS);
    }
}
