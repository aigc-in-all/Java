package com.demo.obfuscated;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年1月4日 下午7:20:29
 * @version V1.0
 */
public class Pack {

    public static void main(String[] args) throws Exception {

        String root = new File(new File(".").getAbsolutePath()).getCanonicalPath();

//        File file = new File(root, "/src/com/demo/obfuscated/PathParser.java");
        File file = new File(root, "app/src/main/java/com/wumii/android/loan/util/PathParser.java");
        System.out.println("[MESSAGE] Path:" + file.getPath());

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = null;
        while ((line = br.readLine()) != null) {
            Pattern p = Pattern.compile("return \"(.*?)\"");
            Matcher m = p.matcher(line);
            if (m.find()) {
                String path = m.group(1);
                String encode = encode(path);
                System.out.println("[MESSAGE] Encoded \"" + path + "\"" + " to \"" + encode + "\"");
                sb.append("return decode(\"" + encode + "\");");
                sb.append("\n");
            } else {
                sb.append(line + "\n");
            }
        }

        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(sb.toString());
        bw.close();
    }

    public static String encode(String content) {
        byte[] bytes = null;
        try {
            bytes = content.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        byte[] randomBytes = new byte[1];
        Random random = new Random();
        random.nextBytes(randomBytes);
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length + 1);
        for (int i = 0, byteLength = bytes.length; i < byteLength; i++) {
            bytes[i] ^= randomBytes[0];
        }
        byteBuffer.put(bytes);
        byteBuffer.put(randomBytes[0]);
        return Base64.encodeBase64String(byteBuffer.array());
    }

}
