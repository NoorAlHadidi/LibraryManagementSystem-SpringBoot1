package com.brightskies.librarysystem1.Model;

import org.springframework.stereotype.Component;

@Component
public abstract class Human {

    private String first;
    private String last;
    private int age;

    public Human() {

    }

    public Human(String fName, String lName, int age) {
        this.first = fName;
        this.last = lName;
        this.age = age;
    }

    public Human(String fName, String lName) {
        this.first = fName;
        this.last = lName;
    }

    public String getFirst() {
        return this.first;
    }

    public String getLast() {
        return this.last;
    }

    public int getAge() {
        return this.age;
    }
}
