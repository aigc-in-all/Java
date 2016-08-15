package com.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月10日 下午2:57:57
 * @version V1.0
 */
public class Test {

    public static void main(String[] args) {
//        String s = "526368（小米帐号安全验证，请勿将验证码提供给他人）【小米】";
        String s = "【大米】526368（小米帐号安全验证，请勿将验证提供给他人）";
        Pattern p1 = Pattern.compile("(【)(.*?)(】)");
        Matcher m1 = p1.matcher(s);
        while(m1.find()) {
            System.out.println(m1.group());
        }
    }

    public static void test1() {
        Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");
        String s = "123aa-34345bb-234cc-00";
        Matcher m = p.matcher(s);
//        p(m.groupCount());//2组
        while(m.find()) {
            p(m.group());//数字字母都有
//            p(m.group(1));//只有数字
            //p(m.group(2));//只有字母
        }
    }
    
    public static void p(Object content) {
        System.out.println(content);
    }

}
