package com.demo.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageDemo {
    
    private ExecutorService exec = Executors.newSingleThreadExecutor();
    
    
    public static void main(String[] args) {
        final MessageDemo demo = new MessageDemo();
        for (int i = 0; i < 5; i++) {
          demo.handleMessage("main1 msg " + i);
        }
        
        for (int i = 0; i < 10; i++) {
            final int tid = i;
            new Thread(new Runnable() {
                
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        demo.handleMessage("thread"+tid+" msg " + j);
                      }
                }
            }).start();
        }
        
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < 5; i++) {
            demo.handleMessage("main2 msg" + i);
          }
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < 5; i++) {
            demo.handleMessage("main3 msg" + i);
          }
    }
    
    private String pendingMsg = null;
    private volatile boolean isRunning;
    private Object lock = new Object();
    
    private void handleMessage(String message) {
        if (isRunning) {
            synchronized (lock) {
                System.out.println("正在执行中，跳过...（" + message + "）");
                pendingMsg = message;
                return;
            }
        }
        
        execute(message);
    }
    
    private void execute(final String message) {
        System.out.println("--->执行消息（" + message + "）");
        isRunning = true;
        
        exec.execute(new Runnable() {
            
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                synchronized (lock) {
                    if (pendingMsg == null) {
                        isRunning = false;
                        System.out.println("没有下一条消息了");
                        return;
                    } else {
                        System.out.println("下一条非空，并清空队列（" + pendingMsg + "）");
                        String msg = pendingMsg;
                        pendingMsg = null;
                        execute(msg);
                    }
                }
            }
        });
    }

}
