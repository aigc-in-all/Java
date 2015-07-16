package com.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

    private static Map<String, String> drafts;

    public static void main(String[] args) throws Exception {
        ExecutorService fileExecutorService = Executors.newSingleThreadExecutor();

        fileExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                Map<String, String> tmpDrafts = null;
                try {
                    Thread.sleep(3000);
                    tmpDrafts = new HashMap<String, String>();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                final Map<String, String> finalDrafts = tmpDrafts;
                if (drafts == null) {
                    if (finalDrafts == null) {
                        drafts = new HashMap<String, String>();
                    }
                }
            }
        });
    }
}
