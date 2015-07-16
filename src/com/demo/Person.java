package com.demo;

public class Person {
    String name;
    int age;
    int score;

    public Person() {
    }

    public Person(String name, int age, int score) {
        super();
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", score=" + score + "]";
    }

}
