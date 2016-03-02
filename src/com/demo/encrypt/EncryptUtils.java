package com.demo.encrypt;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年8月7日 下午6:05:51
 * @version V1.0
 */
public class EncryptUtils {

    private static final String key = "y0EMqGwt8t4bG87U";

    public static void main(String[] args) throws Exception {

        String s = "hello world";

        String ss = "943fa02e4efb64809574265307ce9bd3e89da470c904eb34d11af88ab397c7f450479d4ea1d1899d72d7e24a6f9fe7265208cd78e272667bf11535e04e79d833698810a839d4591878c7d5d579cfbd462ee6cec03a36a43fb8fcb15085ae82a80f725171a4edfafa6e702f0bae1749decbb1659c223c484012138830e3a09b74655d55b927e1bdaf9bd169313196becc62d4e88b00e0089fa314f2c79041a4fbe65b808a30da92268ba078988fead87251589c7a47333385ddfa7d8aa543914a";

        s = FileUtils.readFileToString(new File("C:\\Users\\HeQingbao\\Desktop\\test\\mqtt"), "UTF-8");
        System.out.println(s);

        String en = encrypt(s);
        String dec = decrypt(ss);
        System.out.println(dec);

    }

    public static String encrypt(String content) {
        try {
            byte[] data = processData(content.getBytes("UTF-8"), Cipher.ENCRYPT_MODE);
            return encodeHexString(data);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    public static String decrypt(String content) {
        try {
            byte[] data = processData(decodeHex(content.toCharArray()), Cipher.DECRYPT_MODE);
            return new String(data);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    /**
     * 处理(加密/解密)数据
     *
     * @param content
     *            要被处理的数据内容
     * @param opmode
     *            处理模式：加密{@code Cipher.ENCRYPT_MODE}, 解密
     *            {@code Cipher.DECRYPT_MODE}
     * @return 处理后的数据
     * @throws GeneralSecurityException
     * @throws UnsupportedEncodingException
     */
    private static byte[] processData(byte[] content, int opmode) throws GeneralSecurityException, UnsupportedEncodingException {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(key.getBytes("UTF-8")));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(opmode, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    private static String encodeHexString(byte[] data) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[0x0F & data[i]];
        }
        return new String(out);
    }

    public static byte[] decodeHex(final char[] data) throws Exception {

        final int len = data.length;

        if ((len & 0x01) != 0) {
            throw new Exception("Odd number of characters.");
        }

        final byte[] out = new byte[len >> 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }

    protected static int toDigit(final char ch, final int index) throws Exception {
        final int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new Exception("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }
}
