package com.demo._transient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年2月29日 下午3:58:36
 * @version V1.0
 */
public class Client {

    public static void main(String[] args) {
        LoggingInfo logInfo = new LoggingInfo("MIKE", "MECHANICS");
        System.out.println(logInfo.toString());

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("logInfo.out"));
            out.writeObject(logInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ignore) {
                }
            }
        }

        logInfo.setUid("TOM");

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("logInfo.out"));
            LoggingInfo info = (LoggingInfo) in.readObject();
            System.out.println(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
