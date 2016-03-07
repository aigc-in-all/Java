package com.demo;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月7日 下午2:19:39
 * @version V1.0
 */
public class Demo {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                
            }
        };
        Thread t = new Thread(r);
        t.interrupt();
        t.interrupted();
        t.isInterrupted();
    }

}
