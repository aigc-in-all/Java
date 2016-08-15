package com.demo.encrypt;

import java.nio.charset.Charset;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年8月4日 下午3:45:32
 * @version V1.0
 */
public class XORDemo {

    private static final String key = "y0EMqGwt8t4bG87U";
    private static final Charset charset = Charset.forName("UTF-8");
    private static byte[] keyBytes = key.getBytes(charset);

    public static void main(String[] args) {
        String s = "your are right";
        String enc = encode(s);
        String dec = decode(enc);
        System.out.println(enc);
        System.out.println(dec);
    }

    public static String encode(String input) {
        byte[] inputBytes = input.getBytes(charset);
        for (int i = 0; i < inputBytes.length; i++) {
            for (byte b : keyBytes) {
                inputBytes[i] = (byte) (inputBytes[i] ^ b);
            }
        }
        return new String(inputBytes);
    }

    public static String decode(String input) {
        byte[] inputBytes = input.getBytes(charset);
        byte[] dee = inputBytes;
        for (int i = 0; i < inputBytes.length; i++) {
            for (byte b : keyBytes) {
                inputBytes[i] = (byte) (dee[i] ^ b);
            }
        }
        return new String(inputBytes);
    }

}
