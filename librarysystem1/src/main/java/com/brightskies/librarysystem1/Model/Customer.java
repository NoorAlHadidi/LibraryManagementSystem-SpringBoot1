package com.brightskies.librarysystem1.Model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Customer extends Human {
    private ArrayList<Book> reservedBooks;

}
