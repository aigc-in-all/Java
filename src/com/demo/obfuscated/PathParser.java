package com.demo.obfuscated;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by HeQingbao on 2016/1/4.
 */
public class PathParser {

    public static String home() {
        return "home";
    }

//    public static String encode(String content) {
//        byte[] bytes = null;
//        try {
//            bytes = content.getBytes(Defaults.UTF8);
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
//        byte[] randomBytes = new byte[1];
//        Random random = new Random();
//        random.nextBytes(randomBytes);
//        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length + 1);
//        for (int i = 0, byteLength = bytes.length; i < byteLength; i++) {
//            bytes[i] ^= randomBytes[0];
//        }
//        byteBuffer.put(bytes);
//        byteBuffer.put(randomBytes[0]);
//        return Base64.encodeToString(byteBuffer.array(), Base64.DEFAULT);
//    }

    public static String decode(String content) {
        byte[] bytes = Base64.decodeBase64(content);

        int byteLength = bytes.length;

        if (byteLength == 0) {
            return null;
        }

        byte randomByte = bytes[byteLength - 1];
        for (int i = 0; i < byteLength - 1; i++) {
            bytes[i] ^= randomByte;
        }
        try {
            return new String(bytes, 0, byteLength - 1, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
