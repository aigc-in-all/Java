package com.demo._transient;

import java.io.Serializable;
import java.util.Date;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年2月29日 下午3:49:27
 * @version V1.0
 */
public class LoggingInfo implements Serializable {

    private static final long serialVersionUID = 7702603582718186313L;

    private Date loggingDate = new Date();
    private static String uid;
    private transient String pwd;

    LoggingInfo(String user, String password) {
        uid = user;
        pwd = password;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        String password = null;
        if (pwd == null) {
            password = "NOT SET";
        } else {
            password = pwd;
        }
        return "logon info: \n   " + "user: " + uid + "\n   logging date : " + loggingDate.toString() + "\n   password: " + password;
    }
}
