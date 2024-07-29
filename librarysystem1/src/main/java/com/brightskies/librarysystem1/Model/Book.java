package com.brightskies.librarysystem1.Model;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Book {

    private String id;
    private String title;
    private Author author;
    private String genre;
    private Customer customer;

    public Book() {

    }

    @Autowired
    public Book(String id, String title, Author author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.customer = null;
    }

    public String getID() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Author getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public Optional<Customer> getCustomer() {
        return Optional.ofNullable(this.customer);
    }

    @Autowired
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
