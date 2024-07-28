package com.brightskies.librarysystem1.Model;

import org.springframework.stereotype.Component;

@Component
public abstract class Human {
    private String firstName;
    private String lastName;
    private int age;

    public Human() {

    }

    public Human(String fName, String lName, int age) {
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
    }

    public Human(String fName, String lName) {
        this.firstName = fName;
        this.lastName = lName;
    }
}
