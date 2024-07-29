package com.brightskies.librarysystem1.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Customer extends Human {

    public Customer() {
        super();
    }

    public Customer(String fName, String lName, int age) {
        super(fName, lName, age);
    }


    public Customer(String fName, String lName) {
        super(fName, lName);
    }

}
