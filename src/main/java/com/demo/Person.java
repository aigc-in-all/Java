package com.demo;

public class Person {
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public int getFuck() {
        return 100;
    }

    public String getName() {
        System.out.println("getName");
        return "fuck";
    }

    public String getAge() {
        System.out.println("getAge");
        return age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }


}
