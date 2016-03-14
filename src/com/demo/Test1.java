package com.demo;

import java.util.HashSet;


public class Test1 {

    public static void main(String[] args) throws Exception {

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
}
