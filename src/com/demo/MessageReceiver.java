package com.demo;

import java.util.ArrayList;
import java.util.List;

public class MessageReceiver {

    private static List<String> listeners = new ArrayList<String>();

    public static void addListener(String listener) {
        listeners.add(listener);
    }

    public static String getFirstListener() {
        return listeners.get(0);
    }
}
