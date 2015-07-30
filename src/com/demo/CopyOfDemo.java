package com.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class CopyOfDemo {

    private static ScheduledExecutorService primaryScheduleExecutorService = Executors.newSingleThreadScheduledExecutor();
    private static ScheduledFuture future;

    public static void main(String[] args) throws Exception {
        String s = "hello";
        int i = s.indexOf("#");

        String channel;
        if (i != -1) {
            channel = s.substring(0, i).trim();
        } else {
            channel = s.trim();
        }
        System.out.println(channel);

    }

    protected static String getSql(Object... args) {
        StringBuilder sql = new StringBuilder();
        for (Object arg : args) {
            if (arg != null) {
                sql.append(arg);
            }
        }

        return sql.toString();
    }
}
