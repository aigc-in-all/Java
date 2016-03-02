package com.demo;

import org.codehaus.jackson.annotate.JsonProperty;

public class DumpPerson {
    private String name;

    @JsonProperty("age")
    private int age_test;

//    @JsonProperty("age")
    private String age;

    public DumpPerson() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge_test(int age_test) {
        this.age_test = age_test;
    }

    @Override
    public String toString() {
        return "DumpPerson [name=" + name + ", age_test=" + age_test + ", age=" + age + "]";
    }




}
