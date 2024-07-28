package com.brightskies.librarysystem1.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Customer extends Human {
    private ArrayList<Book> reserved;

    public Customer() {
        super();
    }

    @Autowired
    public Customer(String fName, String lName, int age, ArrayList<Book> reserved) {
        super(fName, lName, age);
        this.reserved = reserved;
    }

    @Autowired
    public Customer(String fName, String lName, ArrayList<Book> reserved) {
        super(fName, lName);
        this.reserved = reserved;
    }
}
