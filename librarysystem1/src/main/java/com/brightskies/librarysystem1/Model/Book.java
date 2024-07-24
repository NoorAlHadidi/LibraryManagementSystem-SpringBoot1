package com.brightskies.librarysystem1.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Book {
    private String bookID;
    private String bookTitle;
    private Author bookAuthor;
    private String bookGenre;
    private Customer bookCustomer;
    public Book(String id, String title, Author author, String genre) {
        this.bookID = id;
        this.bookTitle = title;
        this.bookAuthor = author;
        this.bookGenre = genre;
        this.bookCustomer = null;
    }
}
