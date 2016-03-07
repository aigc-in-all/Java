package com.demo;

import java.text.SimpleDateFormat;
import java.util.Date;



public class AndroidAutoVersionCode {

    private static JacksonMapper mapper = new JacksonMapper(false, true);

    public static void main(String[] args) throws Exception {

        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        System.out.println(f.format(date));

        // 1.0.3
        // 1000003
        // 1.9.10
        // 1009010
        String name = "3.50.10";

//        String[] s1 = {"1", "2", "3"};
//        String[] s2 = {"4", "5"};
//        System.arraycopy(s2, 0, s1, 0, 2);
//
//        for (String s : s1) {
//            System.out.println(s);
//        }

        System.out.println(getVersionCode("0.0.1"));
        System.out.println(getVersionCode("0.1"));
        System.out.println(getVersionCode("1.0"));
        System.out.println(getVersionCode("1.0.1"));
        System.out.println(getVersionCode("1.0.10"));
        System.out.println(getVersionCode("1.1.1"));
        System.out.println(getVersionCode("1.9.1"));
        System.out.println(getVersionCode("9.9.9"));
        System.out.println(getVersionCode("1.10.1"));
        System.out.println(getVersionCode("10.5"));
    }

    private static String getVersionCode(String name) {
        String[] version = {"0", "0", "0"};

        String[] names = name.split("\\.");
        System.arraycopy(names, 0, version, 0, names.length);

        String s1 = version[0];
        String s2 = version[1];
        String s3 = version[2];

        for (int i = 0, size = 3 - s2.length(); i < size; i++) {
            s2 = "0" + s2;
        }

        for (int i = 0, size = 3 - s3.length(); i < size; i++) {
            s3 = "0" + s3;
        }

        return s1 + s2 + s3;
    }

}
