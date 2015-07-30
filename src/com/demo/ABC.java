package com.demo;

public class ABC implements Runnable {

    private String name;
    private Object prev;
    private Object self;

    private ABC(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 5;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.println(name);
                    count--;

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ABC pa = new ABC("A", c, a);
        ABC pb = new ABC("B", a, b);
        ABC pc = new ABC("C", b, c);

        new Thread(pa).start();
        new Thread(pb).start();
        new Thread(pc).start();
    }
}
