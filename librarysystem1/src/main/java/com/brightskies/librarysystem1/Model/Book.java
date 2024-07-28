package com.brightskies.librarysystem1.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Book {
    private String id;
    private String title;
    private Author author;
    private String genre;
    private Customer customer;

    @Autowired
    public Book(String id, String title, Author author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.customer = null;
    }
}
