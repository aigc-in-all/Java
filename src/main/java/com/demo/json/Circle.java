package com.demo.json;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use= JsonTypeInfo.Id.MINIMAL_CLASS)
public class Circle {

    private String id;
    private String name;

    public Circle() {}

    public Circle(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Circle [id=" + id + ", name=" + name + "]";
    }
}
