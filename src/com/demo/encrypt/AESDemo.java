package com.demo.encrypt;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author qingbao.ho@gmail.com
 * @date 2015年8月4日 下午4:34:37
 * @version V1.0
 */
public class AESDemo {

    private static final String key = "y0EMqGwt8t4bG87U";

    public static void main(String[] args) throws Exception {
        String s = "you are right";
        byte[] encodeBytes = encrypt(s, key);
        System.out.println(new String(encodeBytes));
        System.out.println(new String(decrypt(encodeBytes, key)));
    }

    private static byte[] encrypt(String content, String password) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(password.getBytes()));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));

        return cipher.doFinal(content.getBytes("UTF-8"));
    }

    private static byte[] decrypt(byte[] content, String password) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(password.getBytes()));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));

        return cipher.doFinal(content);
    }
}
