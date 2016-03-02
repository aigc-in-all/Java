package com.demo;



public class CopyOfDemo {

    private static JacksonMapper mapper = new JacksonMapper(false, true);

    public static void main(String[] args) throws Exception {

        Person person = new Person("hello", "22");
        String s = mapper.toJson(person);

        System.out.println(s);

        System.out.println(mapper.toJson(s));
    }

}
