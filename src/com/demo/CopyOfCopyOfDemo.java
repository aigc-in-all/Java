package com.demo;

import java.util.HashSet;


public class CopyOfCopyOfDemo {

    private static JacksonMapper mapper = new JacksonMapper(false, true);

    public static void main(String[] args) throws Exception {

//        byte result = (byte) 0xffeffefe;
        System.out.println(2/(4<<1));
        int result = ((0xfe2baf&0xf)|0xff) >> 2/(4<<1);
        System.out.println(result);

        String a = "Marginle";
        String b = "Valaienie";

        HashSet<Character> h1 = new HashSet<>();
        HashSet<Character> h2 = new HashSet<>();

        for (int i = 0, length = a.length(); i < length; i++) {
            h1.add(a.charAt(i));
        }

        for (int i = 0, length = b.length(); i < length; i++) {
            h2.add(b.charAt(i));
        }

        h1.retainAll(h2);
        Character[] res = h1.toArray(new Character[0]);

        String a1 = "hello world";
        String a2 = "world";
        System.out.println(a1.contains(a2));
    }

    private static class A {
        protected void test() throws NullPointerException {
            //
        }
    }

    static String func(String s ){
        return s.length() > 0 ? func(s.substring(1))+ s.charAt(0):"";
        }

    public String getDescription(Object obj) {
        return "obj";
    }

    public String getDescription(String obj) {
        return "string";
    }

//    public void getDescription(String obj) {
//        return obj;
//    }
}
