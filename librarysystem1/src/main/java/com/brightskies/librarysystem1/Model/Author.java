package com.brightskies.librarysystem1.Model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Author extends Human {
    private ArrayList<Book> writtenBooks;
}
