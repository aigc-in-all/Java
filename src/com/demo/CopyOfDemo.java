package com.demo;

public class CopyOfDemo {

    public static void main(String[] args) throws Exception {

        String ss = "{\"n\":\"z\"}";

        JacksonMapper mapper = new JacksonMapper(false);

//        Person p = new Person("zhangsan", 23, 100);

//        String s = mapper.toJson(p);
//        System.out.println(s);

        Person p1 = mapper.fromJson(ss, Person.class);
        System.out.println(p1);
    }
}
